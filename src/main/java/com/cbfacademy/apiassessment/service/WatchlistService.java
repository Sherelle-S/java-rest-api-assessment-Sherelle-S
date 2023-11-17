package com.cbfacademy.apiassessment.service;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
import com.cbfacademy.apiassessment.model.Watchlist;

public interface WatchlistService {

    ResponseEntity<Void> create(List<Watchlist> createList) throws FailedToIOWatchlistException;

    ResponseEntity<List<Watchlist>> readWatchlist() throws FailedToIOWatchlistException;

} 
