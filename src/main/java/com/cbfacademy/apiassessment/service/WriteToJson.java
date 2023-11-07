package com.cbfacademy.apiassessment.service;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteToJson {

    private UserWatchlist copy;

    public void writeToJson( UserWatchlist copy){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(""), copy);

    }
    
    // Watchlist watchlist = new Watchlist();
    // back to java Car car = objectMapper.readValue(new File("src/test/resources/json_car.json"), Car.class);
}
