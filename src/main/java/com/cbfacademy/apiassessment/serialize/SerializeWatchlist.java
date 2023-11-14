package com.cbfacademy.apiassessment.serialize;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// method is responsible for serializing CreateWatchlist data to json object 
@Component
public class SerializeWatchlist {

    private ObjectMapper mapper;
    
    public SerializeWatchlist(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    private static final Logger log = LoggerFactory.getLogger(SerializeWatchlist.class);

// `this.mapper.registerModule(new JavaTimeModule());`  is necessary to avoid `Java 8 date/time type `java.time.LocalDate` not supported by default` issue.
        // public ResponseEntity<String> serialize(Watchlist watchlist) throws FailedToIOWatchlistException {
    public String serialize(List<Watchlist> watchlist) throws FailedToIOWatchlistException{
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
        }
            try {
                return mapper.writeValueAsString(watchlist);
                // String jsonString = mapper.writeValueAsString(watchlist);
                // return new ResponseEntity<>(jsonString, HttpStatus.OK);
            } catch (IOException e) {
                log.error("watchlist failed to write to json in formatList method.", e);
                throw new FailedToIOWatchlistException("Failed to serialize watchlist to json format", e);
            }
        }
}
