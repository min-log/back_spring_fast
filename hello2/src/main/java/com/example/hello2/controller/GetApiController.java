package com.example.hello2.controller;

import com.example.hello2.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    //@GetMapping("hello")
    @GetMapping(path = "hello") // 명시적 지정 -> http://localhost:9090/api/get/hello
    public String hello(){

        return "get hello";
    }

    //예전방식
    //리퀘스트 맵핑으로 다양한 get,post ..등 다양한 방식을 전달 받을 수 있다.
    // 때문에 method로 형식을 지정해주어야했다.
    @RequestMapping(path = "/hi",method = RequestMethod.GET) //get방식의 주소 명시적 지정 -> http://localhost:9090/api/get/hi
    public String hi(){

        return "get hi";
    }

    // http://localhost:9090/api/get/path-variable
    /*
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("pathVariable : " + name);
        return name;
    }

     */
    //변수에는 이름을 다르게 설정해야할때.

    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable (name = "id") String PathName){
        System.out.println("pathVariable : " + PathName);
        return PathName;
    }


    // http://localhost:9090/api/get/query-param?key=value&key1=value1&key2=value2
    //map으로 받을 수 있음
    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            sb.append(entry.getKey() + "= " + entry.getValue() + "\n");
        });
        return sb.toString();
    }


    @GetMapping(path="query-param2")
    public String queryParam2(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam int age
                              ){
        System.out.println("name : " + name);
        System.out.println("email : " + email);
        System.out.println("age : " + age);
        return name + " "+ email + " "+ age;
    }


    @GetMapping(path="query-param3")
    public String queryParam3(UserRequest userRequest){
        System.out.println("name : " + userRequest.getName());
        System.out.println("email : " + userRequest.getEmail());
        System.out.println("age : " + userRequest.getAge());
        return userRequest.toString();
    }

}
