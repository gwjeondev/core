package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1000; // 1000원 할인

    /**
     * 할인가격 계산
     */
    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? discountFixAmount : 0;
    }
}
