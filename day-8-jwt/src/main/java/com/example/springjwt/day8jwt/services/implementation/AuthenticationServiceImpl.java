package com.example.springjwt.day8jwt.services.implementation;

import com.example.springjwt.day8jwt.dto.SignUpRequest;
import com.example.springjwt.day8jwt.entity.Role;
import com.example.springjwt.day8jwt.entity.User;
import com.example.springjwt.day8jwt.repository.UserRepository;
import com.example.springjwt.day8jwt.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //signup new user
    public User signUp(SignUpRequest signUpRequest){
        System.out.println("inside signup");
        User user=new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setRole(signUpRequest.getRole());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        System.out.println("woo");

        return userRepository.save(user);
    }

}
