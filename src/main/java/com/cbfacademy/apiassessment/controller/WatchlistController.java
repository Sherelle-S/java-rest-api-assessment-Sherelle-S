package com.cbfacademy.apiassessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serialize.SerializeWatchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJsonFile;
import com.cbfacademy.apiassessment.service.WatchlistService;
import com.cbfacademy.apiassessment.service.WatchlistServiceImpl;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    

    private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);
    private SerializeWatchlist serializeList;
    private WatchlistService service;
    private WatchlistServiceImpl serviceImpl;
    private WriteToJsonFile writeToJsonFile;
    private Watchlist watchlist;

    @Autowired
    public WatchlistController(SerializeWatchlist serializeList, WatchlistService service,
            WatchlistServiceImpl serviceImpl, WriteToJsonFile writeToJsonFile, Watchlist watchlist) {
        this.serializeList = serializeList;
        this.service = service;
        this.serviceImpl = serviceImpl;
        this.writeToJsonFile = writeToJsonFile;
        this.watchlist = watchlist;
    }


    @PostMapping(value = "/addEntry", produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ResponseEntity<WriteToJsonFile> createItem(@RequestBody CreateWatchlist createList) throws FailedToIOWatchlistException{
        
        return service.create(createList);      

    }
}
