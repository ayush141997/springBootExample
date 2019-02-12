package com.springboot.hellospring.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class productExceptionHandlers{
    @ExceptionHandler(value = TransactionSystemException.class)
    public ResponseEntity<Object> nullInputException(TransactionSystemException t){
        System.err.println(t.toString());
        return new ResponseEntity<>("Either of the inputs are null", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Object> constraintViolationException(DataIntegrityViolationException t){
        System.err.println(t.toString());
        return new ResponseEntity<>("Constraint Violation", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exception(Exception e){
        System.err.println(e.toString());
        return new ResponseEntity<>("Something went wrong!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}