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
        public void setNoBean(Member member) {
            System.out.println("TestBean.setNoBean");
        }

        @Autowired
        public void setNoBean1(@Nullable Member member) {
            System.out.println("TestBean.setNoBean1");
        }

        @Autowired
        public void setNoBean2(Optional<Member> member) {
            System.out.println("TestBean.setNoBean2");
        }
    }

}
