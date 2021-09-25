package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.service.member.MemberService;
import hello.core.service.order.Order;
import hello.core.service.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
/*      ================= spring container 등록 =======================
        - ApplicationContext 를 스프링 컨테이너라 한다.
        - ApplicationContext 는 인터페이스이다.
        - 스프링 컨테이너는 XML을 기반으로 만들 수 있고, 애노테이션 기반의 자바 설정 클래스로 만들 수 있다.
        - 직전에 AppConfig 를 사용했던 방식이 애노테이션 기반의 자바 설정 클래스로 스프링 컨테이너를 만든 것이다.
        - 자바 설정 클래스를 기반으로 스프링 컨테이너( ApplicationContext )를 만들어보자.
        - new AnnotationConfigApplicationContext(AppConfig.class);
        - 이 클래스는 ApplicationContext 인터페이스의 구현체이다.
        - 스프링 컨테이너를 생성할 때는 구성 정보를 지정해주어야 한다.
        - 여기서는 AppConfig.class 를 구성 정보로 지정했다.
        ==============================================================*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

/*      ======================= get bean =============================
        bean의 이름은 AppConfig 클래스의 method명이며, 타입으로는 MemberService, OrderService 인터페이스 임.
        //bean 이름으로 bean 반환
        ==============================================================*/
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member result = memberService.findMember(1L);
        Order order = orderService.createOrder(1L, "ItemA", 135300);

        // output
        System.out.println(order.getDiscountPrice());
        System.out.println(member == result);
    }
}
