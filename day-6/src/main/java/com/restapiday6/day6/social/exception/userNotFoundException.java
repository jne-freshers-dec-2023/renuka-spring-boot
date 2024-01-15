package com.restapiday6.day6.social.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class userNotFoundException extends RuntimeException {
    public userNotFoundException(String s) {
        super(s);
    }
}
