package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    //text
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;

    }
    @PostMapping("/put")
    public User put(@RequestBody User user){
        //생성이 성공했을때 user 값전달
        return user;
    }

    //json
    @PostMapping("/json")
    public ResponseEntity<User> json(@RequestBody User user){
        //생성이 성공했을때 user 값전달
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
