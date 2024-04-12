package com.education.springsecurity.advice;

import com.education.springsecurity.exception.response.ExceptionResponse;
import com.education.springsecurity.exception.response.PersonErrorResponse;
import com.education.springsecurity.exception.UserAlreadyRegistered;
import com.education.springsecurity.exception.UserNoFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class PersonExceptionController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    private ExceptionResponse error(RuntimeException exception) {
        return new ExceptionResponse(exception.getMessage(), System.currentTimeMillis());
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNoFoundException.class)
    private PersonErrorResponse notFoundPerson(UserNoFoundException exception){
       return new PersonErrorResponse(exception.getMessage(), System.currentTimeMillis());
    }


    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ExceptionHandler(UserAlreadyRegistered.class)
    private PersonErrorResponse userAlreadyRegistred(UserAlreadyRegistered exception){
        return new PersonErrorResponse(exception.getMessage(), System.currentTimeMillis());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private Map<String, String> errorsValidationData(MethodArgumentNotValidException exception){
        Map<String, String> errorValid = new HashMap<>();
        //exception.getBindingResult().getAllErrors().stream().map(error -> errorValid.put( ((FieldError) error).getField(), error.getDefaultMessage())).collect(Collectors.toList()); //уточнить


        exception.getBindingResult().getAllErrors().forEach(errors -> {

            String field = ((FieldError)errors).getField();
            String errorMessage = errors.getDefaultMessage();
            errorValid.put(field, errorMessage);
        });
        return errorValid;
    }
}
