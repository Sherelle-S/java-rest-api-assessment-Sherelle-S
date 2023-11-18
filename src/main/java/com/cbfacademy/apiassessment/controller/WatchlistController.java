package com.cbfacademy.apiassessment.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.service.WatchlistService;

// contains the controllers for CRUD request, maps them to the correct endpoint and gets Http responses.
@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    
    
    private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);
    @Autowired
    private WatchlistService service;

    public WatchlistController(WatchlistService service) {
        this.service = service;
    }

    @GetMapping("/showWatchlist")
    public ResponseEntity<List<Watchlist>> readWatchlist() throws FailedToIOWatchlistException, ParseException {
        return service.readWatchlist();
    }

    @GetMapping("/sortedWatchlist")
    public ResponseEntity<List<Watchlist>> sortedWatchlist() throws FailedToIOWatchlistException, ParseException {
        return service.sortedWatchlist();
    }

    @PostMapping(value = "/addEntry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Void> create(@RequestBody List<Watchlist> watchlist) throws FailedToIOWatchlistException{
        return service.create(watchlist);      
        // create some logic that means if client already has stock of item of x name in watchlist, they cannot add another item of that stock they must instead update.
    }

    @PutMapping(value = "/updateEntry/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Void> updateEntry(@PathVariable UUID uuid, @RequestBody Watchlist newEntry){
        return service.updateEntry(uuid, newEntry);
    }
    

    @DeleteMapping(value = "/deleteEntry/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Watchlist>> deleteWatchlistEntry(@PathVariable UUID uuid) throws IOException{
        log.info("Delete process has begun");

        return service.deleteWatchlistEntry(uuid);

    }

}
    
