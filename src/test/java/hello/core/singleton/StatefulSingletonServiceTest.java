package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulSingletonServiceTest {

    @Test
    void statefulSingletonService() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulSingletonService statefulSingletonService1 = ac.getBean("statefulSingletonService", StatefulSingletonService.class);
        StatefulSingletonService statefulSingletonService2 = ac.getBean("statefulSingletonService", StatefulSingletonService.class);

        statefulSingletonService1.order("itemA", 10000);
        statefulSingletonService2.order("itemA", 20000);

        System.out.println("statefulSingletonService2 = " + statefulSingletonService1.getPrice());

        Assertions.assertThat(statefulSingletonService1.getPrice()).isNotEqualTo(10000);
    }

    @Configuration
    static class TestConfig {
        @Bean
        public StatefulSingletonService statefulSingletonService() {
            return new StatefulSingletonService();
        }
    }
}
