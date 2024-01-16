package com.restapiday6.day6.social.controller;

import com.restapiday6.day6.social.model.Users;
import com.restapiday6.day6.social.services.UsersServices;
import com.restapiday6.day6.social.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UsersServices service;

    @GetMapping("/users")
    public List<Users> retriveAllUsers(){
        return service.findall();
    }

    @GetMapping("/users/{id}")
    public Users findOne(@PathVariable int id){
       Users user=service.findById(id);
       if(user== null){
           throw  new UserNotFoundException("User not found with Id:"+id);
       }
       return user;
    }
    @DeleteMapping("/users/{id}")
    public void deleteOne(@PathVariable int id){
        Users users= service.findById(id);
        if(users== null){
            throw  new UserNotFoundException("User not found with Id:"+id);
        }
        service.deleteById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<Users> createUse(@Validated @RequestBody Users user){
        Users saveduser= service.saveUser(user);
        return ResponseEntity.created(null).body(saveduser);
    }

}
