package com.cbfacademy.apiassessment.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidInputException extends IOException {
    public InvalidInputException(){}
    public InvalidInputException(String message){
        super(message);
    }

public InvalidInputException(Throwable cause){
    super(cause);
    }

    public InvalidInputException(String message, Throwable cause){
        super(message, cause);
    }
}
