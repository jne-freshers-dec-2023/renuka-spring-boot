package com.example.springjwt.day8jwt.controller;

import com.example.springjwt.day8jwt.dto.SignUpRequest;
import com.example.springjwt.day8jwt.entity.User;
import com.example.springjwt.day8jwt.services.AuthenticationService;
import com.example.springjwt.day8jwt.services.implementation.AuthenticationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
class AuthenticationController {
    @Autowired
    private AuthenticationServiceImpl authenticationService;


    @PostMapping("/sigup")
    public User signUpUser(@RequestBody SignUpRequest signUpRequest){
        System.out.println("its not working");
        User user= new User();
        user= authenticationService.signUp(signUpRequest);
        return user;
    }
    @GetMapping("/public")
    public String show(){
        return "its working for all";
    }
}
