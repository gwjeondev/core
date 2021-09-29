package hello.core.service.member;

import hello.core.member.Member;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import hello.core.service.member.MemberService;

// 관례..같은 것으로 인터페이스를 구현하는 구현체가 단일 구현체라면 뒤에 Impl를 쓴다.
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Test용
    public MemberRepository memberRepository() {
        return memberRepository;
    }
}
