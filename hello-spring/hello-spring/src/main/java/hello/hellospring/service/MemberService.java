package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    public final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /**
    * 회원가입
    **/
    public Long join(Member member){

        // 같은 이름이 있는 중복 회원은 x
            // 같은 이름이 되어서 반환값이 false 가 될 수 있는 것을 Optional

        //Optional<Member> result = memberRepository.findByName(member.getName());
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();

    }



    //중복회원검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
    *전체 회원 조회
    **/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Optional<Member> findOne(Long memberId){
        return memberRepository.findByid(memberId);
    }



    public Optional<Member> findByid(Long id) {

        return Optional.ofNullable(memberRepository.get(id)); //반환값이 없어도 ~~ 뒤에서 설명..?
    }





}
