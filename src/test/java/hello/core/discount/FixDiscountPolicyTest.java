package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixDiscountPolicyTest {

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Test
    void discount() {
        // given
        Member member = new Member(1L, "spring", Grade.VIP);
        // when
        int discountPrice = discountPolicy.discount(member, 5000);
        // then
        Assertions.assertThat(1000).isEqualTo(discountPrice);
    }
}