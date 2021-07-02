package com.socialMediaApplication.SocialMedia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/hello")
    public String get(){
        return "Hello World";
    }
}
