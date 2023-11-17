package com.cbfacademy.apiassessment.Exceptions;

import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {

    
    public ItemNotFoundException(String id){
        super("Could not find watchList item " + id);
    }

}
