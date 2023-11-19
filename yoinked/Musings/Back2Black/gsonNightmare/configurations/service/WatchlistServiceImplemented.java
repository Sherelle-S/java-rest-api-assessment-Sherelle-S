package com.cbfacademy.apiassessment.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cbfacademy.apiassessment.exceptions.FailureToIOJsonException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJson;
import com.cbfacademy.apiassessment.deserialize.ReadFromJson;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class WatchlistServiceImplemented implements WatchlistService {

    private static final Logger log = LoggerFactory.getLogger(WatchlistServiceImplemented.class);
    private CreateWatchlist createWatchlist;
    private ObjectMapper mapper;
    private Watchlist watchlist;
    private WriteToJson response;
    
    // private ReadFromJson readList;

    // public WatchlistServiceImplemented(  ReadFromJson readList) {
        @Autowired
        public WatchlistServiceImplemented(CreateWatchlist createWatchlist, ObjectMapper mapper, Watchlist watchlist, WriteToJson response) {
        this.createWatchlist = new CreateWatchlist();
        this.mapper = mapper;
        this.response = response;
        this.watchlist = watchlist;

 
    }

    
    /** 
     * @return CreateWatchlist
     */
    public CreateWatchlist getWatchlistData(){
        return createWatchlist;
    }

    
    @Override
    // POST
    // Gets data from user input, creates a WriteToJsons object and writes the response to json
    public ResponseEntity<WriteToJson> create() throws FailureToIOJsonException{
        // UUID CreateWatchlist = createWatchlist.getUuid();
        CreateWatchlist createList = getWatchlistData();
        response = new WriteToJson(createList);
        try {
            response.writeToJson();
        } catch (FailureToIOJsonException e) {
            log.error("File is unable to be written to json, exception ocurred in watchlist service implementation.");
            e.printStackTrace();
            throw new FailureToIOJsonException("Exception occurred while sending data over to json writer.");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

