package hello.core.service.member;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.service.member.MemberService;
import hello.core.service.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    private final MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {
        // given
        Member member = new Member(1L,"spring", Grade.BASIC);
        // when
        memberService.join(member);
        // then
        Member result = memberService.findMember(member.getId());
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findMember() {
        // given
        Member member = new Member(2L,"spring", Grade.VIP);
        // when
        memberService.join(member);
        // then
        Member result = memberService.findMember(member.getId());
        Assertions.assertThat(member).isEqualTo(result);
    }
}