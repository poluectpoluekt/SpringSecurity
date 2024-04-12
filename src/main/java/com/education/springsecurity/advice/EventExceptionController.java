package com.education.springsecurity.advice;

import com.education.springsecurity.exception.ErrorCryptocurrencyDataDownload;
import com.education.springsecurity.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EventExceptionController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ErrorCryptocurrencyDataDownload.class)
    private ExceptionResponse errorLoadData(Exception e){
        return new ExceptionResponse(e.getMessage(), System.currentTimeMillis());
    }
}
