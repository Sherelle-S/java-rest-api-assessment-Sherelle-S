package com.cbfacademy.apiassessment.exceptions;

public class UnexpectedInputOutputException extends IllegalArgumentException{
    public UnexpectedInputOutputException(){}
    public UnexpectedInputOutputException(String message){
        super(message);
    }

public UnexpectedInputOutputException(Throwable cause){
    super(cause);
    }

    public UnexpectedInputOutputException(String message, Throwable cause){
        super(message, cause);
    }
}

