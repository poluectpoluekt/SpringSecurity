package com.education.springsecurity.advice;

import com.education.springsecurity.exception.response.ExceptionResponse;
import com.education.springsecurity.exception.response.PersonErrorResponse;
import com.education.springsecurity.exception.UserAlreadyRegistered;
import com.education.springsecurity.exception.UserNoFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonExceptionController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    private ExceptionResponse error(RuntimeException ex) {
        return new ExceptionResponse(ex.getMessage(), System.currentTimeMillis());
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNoFoundException.class)
    private PersonErrorResponse notFoundPerson(UserNoFoundException e){
       return new PersonErrorResponse(e.getMessage(), System.currentTimeMillis());
    }


    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ExceptionHandler(UserAlreadyRegistered.class)
    private PersonErrorResponse userAlreadyRegistred(UserAlreadyRegistered e){
        return new PersonErrorResponse(e.getMessage(), System.currentTimeMillis());
    }
}
