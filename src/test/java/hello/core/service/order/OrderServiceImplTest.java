package hello.core.service.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import hello.core.service.member.MemberService;
import hello.core.service.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    private final MemberService memberService = new MemberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        // when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        System.out.println(order.toString());
    }
}