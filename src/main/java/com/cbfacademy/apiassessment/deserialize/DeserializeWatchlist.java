package com.cbfacademy.apiassessment.deserialize;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// class deserializes watchlist from json into java object
@Component
public class DeserializeWatchlist {
    
    private ObjectMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(DeserializeWatchlist.class);
    
        public DeserializeWatchlist(ObjectMapper mapper) {
        this.mapper = mapper;
        this.mapper.registerModule(new JavaTimeModule());
        }

        public List<Watchlist> deserializeList(String jsonRepo) throws FailedToIOWatchlistException{
        
        try {
            TypeReference<List<Watchlist>> typeReference = new TypeReference<List<Watchlist>>() {};
            File file = new File(jsonRepo);
            return mapper.readValue(file, typeReference);
        } catch (IOException e) {
            log.error("Watchlist failed to deserialize in deserializeList method.", e);
            throw new FailedToIOWatchlistException("Failed to deserialize watchlist", e);
        }
    }
}
