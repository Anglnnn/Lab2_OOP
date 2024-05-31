package com.example.testest.exception;

public class UserInBlacklistException extends  RuntimeException{
    public UserInBlacklistException(String message){
        super(message);
    }
}
