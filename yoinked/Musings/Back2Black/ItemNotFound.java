package com.cbfacademy.apiassessment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cbfacademy.apiassessment.Exceptions.ItemNotFoundException;

@ControllerAdvice
public class ItemNotFound {
    
    
    /** 
     * @param ex
     * @return String
     */
    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String itemNotFoundHandler(ItemNotFoundException ex){
        return ex.getMessage();
    }
}
