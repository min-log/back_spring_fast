package com.example.hello2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 REST API를 처리하는 컨트롤러
@RequestMapping("/api") //RequestMapping (주소맵핑)URI를 지정해주는 Annotation
public class ApiController {
    @GetMapping("/hello") //GetMapping GET방식으로 열어줄때 http://localhost:9090/api/hello
    public String hello(){
        return "hello spring boot";
    }
}
