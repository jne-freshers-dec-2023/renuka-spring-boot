package com.example.springjwt.day8jwt.repository;

import com.example.springjwt.day8jwt.entity.Role;
import com.example.springjwt.day8jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User , Integer>{
    public Optional<User> findByEmail(String email);
    public User findByRole(String role);
}
