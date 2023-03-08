package com.example.aop.controller;

import com.example.aop.annotation.Timer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Timer //직접 만든 어노테이션
    @DeleteMapping("/delete")
    public void delete(){
        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
