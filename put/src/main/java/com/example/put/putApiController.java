package com.example.put;

import com.example.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class putApiController {

    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto postRequestDto, @PathVariable(name = "userId") Long id){
        System.out.println(id);
        System.out.println(postRequestDto);

        return postRequestDto;
    }
}
