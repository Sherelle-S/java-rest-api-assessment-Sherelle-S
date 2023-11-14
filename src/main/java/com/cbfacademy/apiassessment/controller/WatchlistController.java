package com.cbfacademy.apiassessment.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.deserialize.DeserializeWatchlist;
import com.cbfacademy.apiassessment.deserialize.ReadJsonObject;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
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

    @Autowired
    public WatchlistController(SerializeWatchlist serializeList, WatchlistService service,
            WatchlistServiceImpl serviceImpl, WriteToJsonFile writeToJsonFile) {
        this.serializeList = serializeList;
        this.service = service;
        this.serviceImpl = serviceImpl;
        this.writeToJsonFile = writeToJsonFile;
    }

    @GetMapping("/working")
    public ResponseEntity<List<CreateWatchlist>> readWatchlist() {
        try {
            List<CreateWatchlist> watchlist = watchlistService.readWatchlist();
            return new ResponseEntity<>(watchlist, HttpStatus.OK);
        } catch (JsonWatchlistParsingException e) {
            log.error("Unable to parse json file in GET controller", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return service.readWatchlist();
        
    }


    @PostMapping(value = "/addEntry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <WriteToJsonFile> create(@RequestBody CreateWatchlist createList) throws FailedToIOWatchlistException{
        return service.create(createList);      
        // create some logic that means if client already has stock of item of x name in watchlist, they cannot add another item of that stock they must instead update.
    }
}
