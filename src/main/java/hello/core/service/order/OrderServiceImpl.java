package hello.core.service.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //lombok이 final이 붙은 필드를 생성자로 자동으로 만들어준다. 즉 생성자 코드가 필요 없어진다.
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//  lombok의 @RequiredArgsConstructor 애노테이션을 사용함으로써 final이 붙은 필드를 자동으로 생성자로 만들어 줌으로 생성자 코드가 필요 없어짐.
    @Autowired //의존관계 자동 주입
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        System.out.println("OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인가격 계산

        return new Order(memberId, itemName, itemPrice, discountPrice); //주문정보 객체 return
    }

    //Test용
    public MemberRepository memberRepository() {
        return memberRepository;
    }
}
