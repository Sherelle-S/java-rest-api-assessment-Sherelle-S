package com.cbfacademy.apiassessment.serialize;

import java.io.IOException;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class SerializeWatchlist {

    private ObjectMapper mapper;
    
    public SerializeWatchlist(ObjectMapper mapper) {
        this.mapper = mapper;
        // this.mapper.registerModule(new JavaTimeModule());
    }

    private static final Logger log = LoggerFactory.getLogger(SerializeWatchlist.class);

    // public String formatWatchlist(CreateWatchlist createWatchlist) throws FailedToIOWatchlistException {
        public String formatWatchlist(Watchlist watchlist) throws FailedToIOWatchlistException{

            if (mapper == null) {
                mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
            }
        try {
            return mapper.writeValueAsString(watchlist);
        } catch (IOException e) {
            log.error("watchlist failed to write to json in formatList method.", e);
            throw new FailedToIOWatchlistException("Failed to serialize watchlist to json format", e);
        }
    }
}
