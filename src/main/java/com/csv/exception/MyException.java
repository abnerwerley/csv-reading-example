package com.csv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class MyException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public MyException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
