package com.restapiday6.day6.social.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Users {
    private int id;
    @NotBlank(message = "please enter a number")
    @Size(min = 2)
    private String username;


    private  Long mobile;

    public Users(int id, String username, Long mobile) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
