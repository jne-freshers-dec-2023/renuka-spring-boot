package com.restapiday6.day6.social.controller;

import com.restapiday6.day6.social.model.Users;
import com.restapiday6.day6.social.services.UsersServices;
import com.restapiday6.day6.social.exception.userNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
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
           throw  new userNotFoundException("User not found with Id:"+id);
       }
       return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteOne(@PathVariable int id){
        Users user=service.deleteById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<Users> createUse(@Validated @RequestBody Users user){
        Users saveduser= service.saveUser(user);
//        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(saveduser.getId())
//                .toUri();
        return ResponseEntity.created(null).body(saveduser);
    }

}
