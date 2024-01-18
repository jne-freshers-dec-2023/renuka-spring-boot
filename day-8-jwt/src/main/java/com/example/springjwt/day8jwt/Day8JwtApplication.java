package com.example.springjwt.day8jwt;

import com.example.springjwt.day8jwt.entity.Role;
import com.example.springjwt.day8jwt.entity.User;
import com.example.springjwt.day8jwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class Day8JwtApplication  {


	public static void main(String[] args) {
		SpringApplication.run(Day8JwtApplication.class, args);
		System.out.println("its working");

	}


}
