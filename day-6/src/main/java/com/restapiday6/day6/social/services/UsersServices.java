package com.restapiday6.day6.social.services;

import com.restapiday6.day6.social.model.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UsersServices {
    public static List<Users> users = new ArrayList<>();

    private static int  idCount=0;
    static {
        users.add(new Users(++idCount,"renu", 9552854490L));
        users.add(new Users(++idCount,"shambu",9437628289L));
        users.add(new Users(++idCount,"manju",7464387348L));

    }



    public  List<Users> findall(){
        return  users;
    }

    public Users findById(int id){
        Predicate<Users> predicate= user-> user.getId()== id;
       return  users.stream().filter(predicate).findFirst().orElse(null);

    }

    public Optional<Users> deleteById(int id){
        Predicate<Users> predicate= user-> user.getId()== id;
        users.removeIf(predicate);
        return null;
    }

    public Users saveUser(Users user){
        user.setId(++idCount);
        users.add(user);
        return user;
    }

}