package com.example.springjwt.day8jwt.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    String generateToken(UserDetails userDetails);

    String extractUsername(String token);

    public boolean isTokenValid(String token, UserDetails userDetails);

}
