package com.example.springjwt.day8jwt.services;

import com.example.springjwt.day8jwt.dto.SignUpRequest;
import com.example.springjwt.day8jwt.entity.User;
import org.springframework.stereotype.Service;


public interface AuthenticationService {
    public User signUp(SignUpRequest signUpRequest);
}
