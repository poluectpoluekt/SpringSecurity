package com.education.springsecurity.exception;

public class UserAlreadyRegistered extends RuntimeException{

    public UserAlreadyRegistered(String message){
        super(message);
    }
}
