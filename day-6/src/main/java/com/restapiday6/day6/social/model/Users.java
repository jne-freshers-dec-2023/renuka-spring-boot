package com.restapiday6.day6.social.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Users {
    private int id;
    @NotBlank(message = "please enter a number")
    @Size(min = 2)
    private String username;
    private  Long mobile;
}
