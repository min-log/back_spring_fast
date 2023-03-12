package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    //동시성 문제... 있을수도
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findByid(Long id) {
        return Optional.ofNullable(store.get(id)); //반환값이 없어도 ~~ 뒤에서 설명..?
    }

    @Override
    public Optional<Member> findByName(String name) {
        //찾아지면 반환이됨
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        // 스토어에 멤버들이 반환된다.
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
