package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

/*    clientBean은 싱글톤 빈이므로 스프링 빈이 생성과 종료를 모두 관여한다. 즉 생성시 프로토타입 빈을 주입할 때 이 프로토타입 빈은
    다른 Client가 clientBean을 호출하여도 항상 같은 clientBean을 반환하기에 프로토타입 빈도 역시 같은 참조를 가르킨다.

    clientBean이 내부에 가지고 있는 프로토타입 빈은 이미 과거에 주입이 끝난 빈이다.
    주입 시점에 스프링 컨테이너에 요청해서 프로토타입 빈이 새로 생성이 된 것이지, 사용 할 때마다
    새로 생성되는 것이 아니다!*/
    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int clientBean1Value = clientBean1.logic();

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int clientBean2Value = clientBean2.logic();

        assertThat(clientBean1.getPrototypeBean()).isNotSameAs(clientBean2.getPrototypeBean());

        ac.close();
    }

    @Scope("singleton")
    static class ClientBean {

        //private final PrototypeBean prototypeBean; //ClientBean 생성시점에 주입
        //ObjectFactory > ObjectProvider 자식 관계
        private final ObjectProvider<PrototypeBean> prototypeBeanObjectProvider; //<T>에 해당하는 빈을 찾아주는 기능을 제공

        public ClientBean(ObjectProvider<PrototypeBean> prototypeBeanObjectProvider) {
            this.prototypeBeanObjectProvider = prototypeBeanObjectProvider;
        }

        public int logic() {
            //<T>에 해당하는 빈을 getObject를 통해 생성하여 항상 새로운 프로토타입 빈을 가져옴.
            PrototypeBean prototypeBean = prototypeBeanObjectProvider.getObject();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }

        public PrototypeBean getPrototypeBean() {
            return prototypeBeanObjectProvider.getObject();
        }

        @PostConstruct
        public void init() {
            System.out.println("ClientBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("ClientBean.destroy " + this);
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy " + this);
        }
    }
}
