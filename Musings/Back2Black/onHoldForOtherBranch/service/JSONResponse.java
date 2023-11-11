package com.cbfacademy.apiassessment.service;

// Class holds the JSON response that will be the returned from the converter. class came from  error message saying there was 'no converter for class writeToJSon.'
public class JSONResponse {

    private String returnedData;

    public String getReturnedData() {
        return returnedData;
    }

    public void setReturnedData(String message) {
        this.returnedData = message;
    }

    public JSONResponse(String message) {
        this.returnedData = message;
    }

    
    
}
