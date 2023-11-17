package com.cbfacademy.apiassessment.controller;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serializingActions.SerializeWatchlist;
import com.cbfacademy.apiassessment.serializingActions.WriteToJsonFile;
import com.cbfacademy.apiassessment.service.WatchlistService;
import com.cbfacademy.apiassessment.service.WatchlistServiceImpl;

// contains the controllers for CRUD request, maps them to the correct endpoint and gets Http responses.
@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    

    private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);
    private WatchlistService service;
    private WatchlistServiceImpl serviceImpl;


    @Autowired
    public WatchlistController(WatchlistService service, WatchlistServiceImpl serviceImpl) {
        this.service = service;
        this.serviceImpl = serviceImpl;
    }

    @GetMapping("/showWatchlist")
    public ResponseEntity<List<Watchlist>> readWatchlist() throws FailedToIOWatchlistException, ParseException {
        return service.readWatchlist();
    }

    @PostMapping(value = "/addEntry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Void> create(@RequestBody List<Watchlist> watchlist) throws FailedToIOWatchlistException{
        return service.create(watchlist);      
        // create some logic that means if client already has stock of item of x name in watchlist, they cannot add another item of that stock they must instead update.
    }

}
    
