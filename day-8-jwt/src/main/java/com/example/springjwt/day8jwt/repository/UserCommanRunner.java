package com.example.springjwt.day8jwt.repository;

import com.example.springjwt.day8jwt.entity.Role;
import com.example.springjwt.day8jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserCommanRunner implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        //Optional<User>
        User adminAccount= userRepository.findByRole("ADMIN");
        //if(adminAccount.isPresent()){

        if(adminAccount== null){
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setFirstname("admin");
            user.setLastname("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setRole("ADMIN");
            userRepository.save(user);
        }

    }
}
