package hello.core.service;

import hello.core.member.Member;

// 관례..같은 것으로 인터페이스를 구현하는 구현체가 단일 구현체라면 뒤에 Impl를 쓴다.
public class MemberServiceImpl implements MemberService {
    @Override
    public void join(Member member) {

    }

    @Override
    public void findMember(Long memberId) {

    }
}
