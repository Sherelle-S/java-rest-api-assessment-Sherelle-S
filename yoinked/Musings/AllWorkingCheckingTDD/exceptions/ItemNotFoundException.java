package com.cbfacademy.apiassessment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {

    
    public ItemNotFoundException(String id){
        super("Could not find watchList item " + id);
    }

    public ItemNotFoundException(String message, String cause){
        super(message);
    }

}
