package com.cbfacademy.apiassessment.exceptions;

public class ExceptionTemp extends IllegalArgumentException{
    public ExceptionTemp(){}
    public ExceptionTemp(String message){
        super(message);
    }

public ExceptionTemp(Throwable cause){
    super(cause);
    }

    public ExceptionTemp(String message, Throwable cause){
        super(message, cause);
    }
}

