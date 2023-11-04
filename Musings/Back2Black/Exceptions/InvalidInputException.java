package com.cbfacademy.apiassessment.Exceptions;

import java.io.IOException;

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
