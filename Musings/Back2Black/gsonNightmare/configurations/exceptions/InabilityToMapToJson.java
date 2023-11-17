package com.cbfacademy.apiassessment.exceptions;

import java.io.Closeable;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.JsonMappingException;

// Exception is thrown when there is an inability to object map to json.
public class InabilityToMapToJson extends JsonMappingException{

    public InabilityToMapToJson(Closeable processor, String msg, JsonLocation loc) {
        super(processor, msg, loc);
        //TODO Auto-generated constructor stub
    }
    
}
