package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import hello.core.service.member.MemberService;
import hello.core.service.member.MemberServiceImpl;
import hello.core.service.order.OrderService;
import hello.core.service.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*애플리케이션의 실제 동작(구현)에 필요한 구현체 생성을 한다.
클라이언트(Service)는 역할, 즉 인터페이스에만 집중 한다.*/
@Configuration
public class AppConfig {

    // MemberRepository 역할에 대한 구현체는 MemoryMemberRepository
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // DiscountPolicy 역할에 대한 구현체는 RateDiscountPolicy
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    // MemberService 역할에 대한 구현체는 MemberServiceImpl
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // OrderService 역할에 대한 구현체는 OrderServiceImpl
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
