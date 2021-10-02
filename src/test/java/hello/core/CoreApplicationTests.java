package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
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
            BeanDefinition beanDefinition = bf.getBeanDefinition(beanDefinitionName);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = bf.getBean(beanDefinitionName); //bean 이름으로 bean 반환
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }
    }

}
