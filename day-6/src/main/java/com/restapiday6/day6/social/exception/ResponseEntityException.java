package com.restapiday6.day6.social.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ResponseEntityException {
    @ExceptionHandler(userNotFoundException.class)
    public ResponseEntity<ErrorDetails>  usernotFoundException(userNotFoundException ex){

        String message= ex.getMessage();
        System.out.println(message);
        ErrorDetails errorDetails= new ErrorDetails(false,message);
        return  new ResponseEntity<ErrorDetails>(errorDetails,NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetails>  validationException(ValidationException ex){

        String message= ex.getMessage();
        System.out.println(message);
        ErrorDetails errorDetails= new ErrorDetails(false,message);
        return  new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails>  exceptionHandler(userNotFoundException ex){

        String message= ex.getMessage();
        System.out.println(message);
        ErrorDetails errorDetails= new ErrorDetails(false,message);
        return  new ResponseEntity<ErrorDetails>(errorDetails,NOT_FOUND);
    }



}
