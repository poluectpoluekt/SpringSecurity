package com.education.springsecurity.exception;

import java.io.IOException;

public class UserNoFoundException extends RuntimeException {

    public UserNoFoundException(String message){
        super(message);
    }
}
