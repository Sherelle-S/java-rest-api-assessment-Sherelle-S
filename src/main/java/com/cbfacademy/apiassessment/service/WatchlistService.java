package com.cbfacademy.apiassessment.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.cbfacademy.apiassessment.deserialize.ReadJsonObject;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJsonFile;

public interface WatchlistService {

    ResponseEntity<WriteToJsonFile> create(CreateWatchlist createList) throws FailedToIOWatchlistException;
    
    ResponseEntity<List<CreateWatchlist>> readWatchlist();

} 
