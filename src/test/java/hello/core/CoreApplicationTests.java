package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;

// @SrpingBootTest: 스프링이 자동으로 스프링 컨테이너를 만들어서 테스트를 통합해서 할 수 있게끔 해줌.
@SpringBootTest
class CoreApplicationTests {

    @Autowired DefaultListableBeanFactory bf;

    @Test
    void contextLoads() {
        String[] beanDefinitionNames = bf.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

}
