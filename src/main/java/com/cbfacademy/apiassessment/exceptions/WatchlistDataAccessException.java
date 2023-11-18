package com.cbfacademy.apiassessment.exceptions;

import java.io.IOException;

public class WatchlistDataAccessException extends IOException{

    public WatchlistDataAccessException(){}
    public WatchlistDataAccessException(String message){
        super(message);
    }

    public WatchlistDataAccessException(String message, String exception){
        super(message);
    }

    public WatchlistDataAccessException(Throwable cause){
    super(cause);
    }

    public WatchlistDataAccessException(String message, Throwable cause){
        super(message, cause);
    }
    
}
