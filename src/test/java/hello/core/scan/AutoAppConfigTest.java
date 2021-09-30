package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.service.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    @DisplayName("ComponentScan basePackages 검사")
    void basePackages() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //모든 빈 이름 반환
        //Assertions.assertThat(beanDefinitionNames.length).isEqualTo(3);
    }
}
