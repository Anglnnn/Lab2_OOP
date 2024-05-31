package com.example.testest.exception;

public class UserLoginNotNullException extends RuntimeException {
    public UserLoginNotNullException(String message){
        super(message);
    }
}
