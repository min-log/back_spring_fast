package com.example.validation2.controller;

import com.example.validation2.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public User user(@Valid @RequestBody User user){
        System.out.println(user);
        return user;

    }
}
