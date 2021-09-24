package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.repository.MemoryMemberRepository;
import hello.core.service.member.MemberService;
import hello.core.service.member.MemberServiceImpl;
import hello.core.service.order.OrderService;
import hello.core.service.order.OrderServiceImpl;

/*애플리케이션의 실제 동작(구현)에 필요한 구현체 생성을 한다.
클라이언트(Service)는 역할, 즉 인터페이스에만 집중 한다.*/
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
