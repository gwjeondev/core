package hello.core.service.member;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.repository.MemoryMemberRepository;
import hello.core.service.member.MemberService;
import hello.core.service.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    private MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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