package com.example.validation2.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class User {
    @NotBlank
    private String name;
    @Max(value = 80)
    private int age;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",message = "핸드폰번호 양식과 맞지 않습니다.")
    private String phoneNumber;
}
