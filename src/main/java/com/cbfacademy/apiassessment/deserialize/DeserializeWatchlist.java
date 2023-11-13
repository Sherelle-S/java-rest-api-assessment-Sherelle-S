package com.cbfacademy.apiassessment.deserialize;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class DeserializeWatchlist {
    
    private ObjectMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(ReadFromJson.class);
    
        public DeserializeWatchlist(ObjectMapper mapper) {
        this.mapper = mapper;
        }

        public Watchlist writeToJson(Watchlist watchlist){
        
            String jsonOutput = "";
             if (mapper == null) {
                mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
            }
            try {
            return mapper.readValue(jsonOutput, Watchlist.class);
        } catch (IOException e) {
            log.error("watchlist failed to write to json in formatList method.", e);
            throw new FailedToIOWatchlistException("Failed to serialize watchlist to json format", e);
        }
        
        }
}
