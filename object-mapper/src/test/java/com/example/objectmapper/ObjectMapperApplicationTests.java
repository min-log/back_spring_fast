package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("--------------");
        //text JSON -> Object
        //object -> text
        //controller

        var objectMapper= new ObjectMapper();

        //object -> text
        //object mapper가 get method를 사용한다.
        var user = new User("JI",10);
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // 객체에 디폴트 생성자가 필요하다.
        var objectUser = objectMapper.readValue(text , User.class);
        System.out.println(objectUser);

    }

}
