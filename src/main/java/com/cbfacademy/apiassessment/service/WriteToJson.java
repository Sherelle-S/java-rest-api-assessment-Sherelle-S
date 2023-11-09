package com.cbfacademy.apiassessment.service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteToJson {

    private static final Logger log = LoggerFactory.getLogger(WriteToJson.class);
    private UserWatchlist copy;


    public WriteToJson(UserWatchlist copy) {
        this.copy = copy;
    }

    public void writeToJson() throws FailureToIOJsonException {
        ObjectMapper objectMapper = new ObjectMapper();
        String outputFile = "JsonWatchlist.json";
        File file = new File(outputFile);
        try {

            if (file.exists()) {
                // If the file exists, read the current data
                List<UserWatchlist>currentData = objectMapper.readValue(file, new TypeReference<List<UserWatchlist>>() {});
                currentData.add(copy);
                objectMapper.writeValue(file, currentData);
            } else {
                List<UserWatchlist> newData = Collections.singletonList(copy);
                newData.add(copy);
                objectMapper.writeValue(file, newData);
            }

        } catch (IOException e) {
            log.error("Copy of user watchlist failed to write to Json file.", e);
            throw new FailureToIOJsonException("IOException occurred while attempting to write input to JSON.", e);
        } 
    }
}
