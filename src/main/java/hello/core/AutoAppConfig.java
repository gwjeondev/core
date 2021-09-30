package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 스캔 package를 지정. 지정된 패키지부터 하위로 스캔함.
        basePackages =  {"hello.core.repository", "hello.core.service.member"},
        // 클래스의 패키지부터 하위로 스캔함.
        basePackageClasses = AutoAppConfig.class,
/*        // @@@아무것도 지정 하지 않을시 ComponentScan이 있는 해당 패키지부터 하위로 스캔한다.@@@
        참고로 스프링 부트를 사용하면 스프링 부트의 대표 시작 정보인 @SpringBootApplication 를 이
        프로젝트 시작 루트 위치에 두는 것이 관례이다. (그리고 이 설정안에 바로 @ComponentScan 이 들어있다!*/
        // 컴포넌트 스캔중 제외 할 타입을 필터함.
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
