package com.cbfacademy.apiassessment.Exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String id){
        super("Could not find watchList item " + id);
    }

}
