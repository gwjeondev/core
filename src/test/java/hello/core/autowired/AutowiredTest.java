package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false)
/*        Parameter Member는 스프링이 관리하는 빈이 아님으로 Autowired required를 false로 지정함.
        default는 true이며 반드시 Parameter 타입이 Bean으로 등록되있어야 함, false일 경우 선택적으로 주입함으로
        자동 주입 할 대상이 없으면(Bean) 호출하지 않음 */
        public void setNoBean(Member member) {
            System.out.println("member = " + member);
        }

        @Autowired
        //자동주입할 대상(Bean)이 없으면 null이 입력
        public void setNoBean1(@Nullable Member member) {
            System.out.println("member = " + member);
        }

        @Autowired
        //자동주입할 대상이(Bean) 없으면 Optional.empty가 입력됨.
        public void setNoBean2(Optional<Member> member) {
            System.out.println("member = " + member);
        }
    }

}
