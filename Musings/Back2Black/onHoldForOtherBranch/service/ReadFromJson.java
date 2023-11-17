package com.cbfacademy.apiassessment.service;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReadFromJson {

    private static final Logger log = LoggerFactory.getLogger(ReadFromJson.class);

    String inputPath = "JsonWatchlist.json";
// do you retrieve all items from json deserialize them all and then search id
// do you search id then deserialize from json update and return file
// creates a map of key value pairs to deserialize to and update 
    public List<Watchlist> readFromJson(String inputPath) throws FailureToIOJsonException{
        ObjectMapper mapper = new ObjectMapper();
        List<Watchlist> watchlist;
        try {
            watchlist = mapper.readValue(new File(inputPath), new TypeReference<List<Watchlist>>() {});
            // TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>(){};
            // Map<String, Object> map = mapper.readValue(jsonInput, typeRef);
            // return map.toString();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Failure to read json input from ReadFromJson method.", e);
            throw new FailureToIOJsonException("Failed to read JSON input.", e);
        }
        return watchlist;
    }

    // public String showWatchlist() throws FailureToIOJsonException{
    //     try {
    //         ReadFromJson reader = new ReadFromJson();
    //         String deserializeJson = reader.ReadFromJson(null);
    //         return deserializeJson;
    //     } catch (FailureToIOJsonException e) {
    //         log.error("Failed to print deserialize json in showWatchlist method.", e);
    //         throw new FailureToIOJsonException("unable to show printed json.", e);
    //     }
    // }
    
}
