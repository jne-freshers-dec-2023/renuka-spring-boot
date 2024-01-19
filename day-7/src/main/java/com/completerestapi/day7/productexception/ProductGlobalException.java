package com.completerestapi.day7.productexception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ProductGlobalException extends RuntimeException {
    //NoProductFoundException
    @ExceptionHandler(NoProductFoundException.class)
    public ResponseEntity<ErrorDetails> noProductFoundException(NoProductFoundException ex){
        String message=ex.getMessage();
        ErrorDetails errorDetails= new ErrorDetails(false,message);
        return  new ResponseEntity<ErrorDetails>(errorDetails,NOT_FOUND);
    }
    //NoResourceFoundException
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorDetails> noResourceFoundException(NoResourceFoundException ex){
        String message=ex.getMessage();
        ErrorDetails errorDetails= new ErrorDetails(false,message);
        return  new ResponseEntity<ErrorDetails>(errorDetails,BAD_REQUEST);
    }



}
