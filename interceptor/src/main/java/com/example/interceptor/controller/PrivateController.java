package com.example.interceptor.controller;

import com.example.interceptor.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/private")
@Auth
public class PrivateController {
        // 내부사용자 인증된 사용자
    //권한 차이
    //Auth 어노테이션이 붙어있으면 세션을 검사해서 있을때 통과 , 없으면 통과 하지 못함.
    @GetMapping("/hello")
    public String hello(){

        return "private hello";
    }
}
