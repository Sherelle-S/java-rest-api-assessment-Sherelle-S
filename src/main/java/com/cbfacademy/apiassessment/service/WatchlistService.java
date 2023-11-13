package com.cbfacademy.apiassessment.service;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJsonFile;

public interface WatchlistService {

    ResponseEntity<WriteToJsonFile> create(CreateWatchlist createList) throws FailedToIOWatchlistException;
    
} 
