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
        // spring container 등록
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // get bean
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
