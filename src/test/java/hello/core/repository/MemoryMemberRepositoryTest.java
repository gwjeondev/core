package hello.core.repository;

import hello.core.member.Grade;
import hello.core.member.Member;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void save() {
        // given
        Member member = new Member(1L,"spring", Grade.BASIC);
        // when
        memberRepository.save(member);
        // then
        Member result = memberRepository.findById(member.getId());
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findById() {
        // given
        Member member = new Member(2L, "spring", Grade.VIP);
        // when
        memberRepository.save(member);
        // then
        Member result = memberRepository.findById(member.getId());
        Assertions.assertThat(member).isEqualTo(result);
    }
}