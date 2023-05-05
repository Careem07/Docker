package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @GetMapping(value = "/userJson")
    public User displayUserAsJson() {
        return new User(1 , "kareem" , "2400");
    }
}
