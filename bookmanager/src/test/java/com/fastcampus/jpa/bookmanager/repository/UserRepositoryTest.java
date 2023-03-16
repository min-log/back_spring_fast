package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest //스프킹 컨텍스트를 실행해서 태스트
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void crud(){ //creat , read ,update,delete 기본적인
        userRepository.save(new Users()); //유저 생성 및 저장
        System.out.println(">>"+userRepository.findAll());//유저 테이블의 모든 데이터를 리스트 형식으로 가져온다.
    }

}