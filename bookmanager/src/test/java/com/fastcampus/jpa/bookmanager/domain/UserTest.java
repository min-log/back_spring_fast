package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void test(){
        Users user = new Users();
        user.setEmail("mm@gmail.com");
        user.setName("MM");
        System.out.println(user);
        Users user1 = Users.builder().name("길동이").email("ma@naver.com").build();

    }

}