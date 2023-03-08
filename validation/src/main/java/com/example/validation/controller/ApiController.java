package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {
    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                //오브젝트의 에러를 받아서.
                    //어떤 필드의 에러인지 오브젝트 에러를 형변환하여 넣어준다.
                    // 메시지를 통해 에러의 내용도 알수 있다.
                FieldError field = (FieldError) objectError;
                String message = field.getDefaultMessage();

                System.out.println("필드 :" + field.getField());
                System.out.println("에러 내용 :" + message);
                sb.append("field : "+field.getField());
                sb.append("message : "+message);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        return ResponseEntity.ok(user);
    }
}
