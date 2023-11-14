package com.cbfacademy.apiassessment.deserialize;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// class deserializes watchlist from json into json object
@Component
public class DeserializeWatchlist {
    
    private ObjectMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(DeserializeWatchlist.class);
    
        public DeserializeWatchlist(ObjectMapper mapper) {
        this.mapper = mapper;
        }

        public List<CreateWatchlist> convertToJava(String jsonOutput) throws FailedToIOWatchlistException{
        
            // String jsonOutput = "";
             if (mapper == null) {
                mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
            }
            try {
                TypeReference<List<CreateWatchlist>> typeReference = new TypeReference<List<CreateWatchlist>>() {
                };
            return mapper.readValue(jsonOutput, typeReference);
        } catch (IOException e) {
            log.error("Watchlist object failed to write to java in convertToJava method.", e);
            throw new FailedToIOWatchlistException("Failed to serialize watchlist object to json format", e);
        }
    }
}
