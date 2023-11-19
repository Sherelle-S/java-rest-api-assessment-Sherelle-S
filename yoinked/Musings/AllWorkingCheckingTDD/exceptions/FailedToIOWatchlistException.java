package com.cbfacademy.apiassessment.exceptions;

import java.io.IOException;

public class FailedToIOWatchlistException extends IOException{

    public FailedToIOWatchlistException(){}
    public FailedToIOWatchlistException(String message){
        super(message);
    }

    public FailedToIOWatchlistException(String message, String exception){
        super(message);
    }

    public FailedToIOWatchlistException(Throwable cause){
    super(cause);
    }

    public FailedToIOWatchlistException(String message, Throwable cause){
        super(message, cause);
    }
    
}
