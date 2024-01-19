package com.completerestapi.day7.productexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoResourceFoundException extends RuntimeException {
    public  NoResourceFoundException(String s){
        super(s);
    }
}
