package com.example.springjwt.day8jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String role;
}
