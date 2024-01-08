package com.springday2.learnspringboot.day1;

import com.springday2.learnspringboot.day1.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RestController
public class FetchingAPI {

    @RequestMapping("/users")
    public List<Users>  retriveAllUsers(){
        return Arrays.asList(
                new Users(1, "Renuka", "renuka@gmail.com"),
                new Users(2, "Shambu", "shambu@gmail.com"),
                new Users(3, "Manju", "manju@gmail.com"));
    }

}
