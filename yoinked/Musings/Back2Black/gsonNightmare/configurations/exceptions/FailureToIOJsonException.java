package com.cbfacademy.apiassessment.exceptions;

import java.io.IOException;

public class FailureToIOJsonException extends IOException{
    public FailureToIOJsonException(){}
    public FailureToIOJsonException(String message){
        super(message);
    }

public FailureToIOJsonException(Throwable cause){
    super(cause);
    }

    public FailureToIOJsonException(String message, Throwable cause){
        super(message, cause);
    }
}

