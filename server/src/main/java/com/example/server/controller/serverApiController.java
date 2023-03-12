package com.example.server.controller;


import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class serverApiController {
    @GetMapping("/naver")
    public String naver(){

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query","갈비집")
                .queryParam("display","10")
                .queryParam("start","1")
                .queryParam("sort","random")
                .encode(Charset.forName("UTF-8")) // 요청한 인코딩값
                .build().toUri();

        log.info("uri{}",uri);
        RestTemplate restTemplate = new RestTemplate();

        //header 세팅 , get으로 요청하기 때문에 안에 들어가는 값은 Void
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "ejcG2iZX5lUBcHNinBWI")
                .header("X-Naver-Client-Secret","4eEhLNfZ2Y")
                .build();

        // get > post exchange
        ResponseEntity<String> result = restTemplate.exchange(req,String.class);
        return result.getBody();


    }


    @GetMapping("/hello")
    public User hello(@RequestParam String name,@RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }



// 일반 post요청
//    @PostMapping("/user/{userId}/name/{userName}")
//    public User post(@RequestBody User user, @PathVariable int userId,@PathVariable String userName){
//        log.info("user id:{} , user name:{}",userId,userName);
//        log.info("client user: {}",user);
//
//        return user;
//    }
//
//  exchange
//    @PostMapping("/user/{userId}/name/{userName}")
//    public User post(@RequestBody User user,
//                      @PathVariable int userId,
//                      @PathVariable String userName,
//                      @RequestHeader("x-authorization") String authorization,
//                     @RequestHeader("custom-header") String customHeader
//    ){
//        log.info("user2 id:{} , user2 name:{}",userId,userName);
//        log.info("user2 authorization:{} , user2 customHeader:{}",authorization,customHeader);
//        log.info("client user: {}",user);
//
//        return user;
//    }


    // 실제 많이 사용되는 예시
    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
            //HttpEntity<String> entity, //전체 보낸 내역을 뽑을 수 잇다.
            @RequestBody Req<User> user,
            @PathVariable int userId,
            @PathVariable String userName,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("custom-header") String customHeader
    ){
        //log.info("entity :{}",entity.getBody());
        log.info("user3 id:{} , user3 name:{}",userId,userName);
        log.info("user3 authorization:{} , user3 customHeader:{}",authorization,customHeader);
        log.info("client user: {}",user);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );
        response.setResBody(user.getResBody());
        return response;
    }
}
