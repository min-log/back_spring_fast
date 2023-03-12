package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//html 리소스를 찾게됨
@Controller
public class pageController {
    @RequestMapping("main")
    public String main(){
        return "main.html";
    }

    //json
    //ResponseEntity

    //ResponsBody
    @ResponseBody
    @GetMapping("/user")
    public User user(){
        User user = new User();
        //var user = new User(); //타입추론 자바 11버전 부터 사용가능
        user.setName("다시");
        user.setAddress("집");
        return user;
    }

}
