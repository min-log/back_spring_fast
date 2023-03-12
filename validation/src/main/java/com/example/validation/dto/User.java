package com.example.validation.dto;

import com.example.validation.anotation.YearMonth;

import javax.validation.constraints.*;


public class User {


    @NotBlank(message = "이름을 확인해주세요.")
    private String name;
    @Min(value = 10, message = "나이를 확인해주세요.")
    private int age;
    @Email(message = "이메일 형식을 확인해주세요.")
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",message = "핸드폰 번호 양식과 맞지 않습니다. ex:010-0000-0000")
    private String phoneNumber;

    //날짜를 받는 필드
   // @Size(min=6,max = 6,message = "날짜를 정확하게 입력해주세요 ex ) yyyyMM")
    @YearMonth(pattern="yyyyMM")
    private String reqYearMonth;


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }
}
