package com.restapiday6.day6.social.exception;

public class ValidationException extends  RuntimeException{
    ValidationException(String s){
        super(s);
    }
}
