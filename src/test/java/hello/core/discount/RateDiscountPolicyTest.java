package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.service.member.MemberService;
import hello.core.service.member.MemberServiceImpl;
import hello.core.service.order.Order;
import hello.core.service.order.OrderService;
import hello.core.service.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {


    private final OrderService orderService = new OrderServiceImpl();
    private final MemberService memberService = new MemberServiceImpl();


    @Test
    @DisplayName("VIP는 10% 할인이 적용 되어야 한다.")
    void discount() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 153500);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(15350);
    }
}