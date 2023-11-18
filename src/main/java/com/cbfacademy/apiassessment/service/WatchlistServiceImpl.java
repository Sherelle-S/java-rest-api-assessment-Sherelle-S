package com.cbfacademy.apiassessment.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.controller.WatchlistController;
import com.cbfacademy.apiassessment.crudActions.appendingActions.createEntry.CreateFirstItem;
import com.cbfacademy.apiassessment.crudActions.appendingActions.createEntry.RunCreatingActions;
import com.cbfacademy.apiassessment.crudActions.appendingActions.deleteEntries.RunDeleteEntry;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.RunGetWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.sortWatchlistByName.SortWatchlistByName;
import com.cbfacademy.apiassessment.crudActions.appendingActions.updateOneEntry.RunUpdatingMethods;
import com.cbfacademy.apiassessment.crudActions.appendingActions.updateOneEntry.UpdatePutEntry;
import com.cbfacademy.apiassessment.exceptions.WatchlistDataAccessException;
import com.cbfacademy.apiassessment.exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// service layer, holds business logic to controller methods 
@Service
@Component
public class WatchlistServiceImpl implements WatchlistService {

    String jsonRepo = "JsonWatchlist.json";

    @Autowired
    private CreateFirstItem createFirstItem;
    private RunDeleteEntry deleteEntry;
    private ObjectMapper mapper;
    private ReadExistingWatchlist readList;
    private RunCreatingActions runCreateItem;
    private RunUpdatingMethods runUpdatingMethods;
    private SortWatchlistByName sortByName;
    // private UpdatePutEntry updateOneEntry;

    public WatchlistServiceImpl(CreateFirstItem createFirstItem, RunDeleteEntry deleteEntry, ObjectMapper mapper, RunCreatingActions runCreateItem, RunUpdatingMethods runUpdatingMethods, SortWatchlistByName sortByName, ReadExistingWatchlist readList) {
        this.createFirstItem = createFirstItem;
        this.deleteEntry = deleteEntry;
        this.mapper = mapper.registerModule(new JavaTimeModule());
        this.mapper = mapper;
        this.runCreateItem = runCreateItem;
        this.runUpdatingMethods = runUpdatingMethods;
        this.readList = readList;
        this.sortByName = sortByName;
    }

    private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);

    // return response entity for creating watchlist

    public List<Watchlist> getCurrentWatchlist() throws IOException{
        // try {
            List<Watchlist> currentWatchlist = readList.readExistingWatchlist(jsonRepo, mapper);
            return currentWatchlist;
        // } catch (WatchlistDataAccessException e) {
        //     log.error("Watchlist data cannot be accessed, prroblem in watchlist service implementations", e);
        //     throw new IOException(e.getMessage());
            
        // }
        
    }
    @Override
    public ResponseEntity<Void> create(List<Watchlist> watchlist) throws WatchlistDataAccessException {
        try {
            File file = new File(jsonRepo);
            if(!file.exists()){
                file.createNewFile();
                createFirstItem.CreateFirstEntry(watchlist, jsonRepo);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else if(file.exists() && file.length() == 0) {
                createFirstItem.CreateFirstEntry(watchlist, jsonRepo);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                runCreateItem.appendNewItems(watchlist, jsonRepo);
                // runCreateItem.appendNewItems(watchlist, watchlist, jsonRepo);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        } catch (Exception e) {
            log.error("Error processing file: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // return response entity and watchlist for read requests
    @Override
    public ResponseEntity<List<Watchlist>> readWatchlist() {
        try {
            List<Watchlist> retrieveWatchlist = getCurrentWatchlist();;
            if(retrieveWatchlist.size() <= 0){
                return (ResponseEntity<List<Watchlist>>) ResponseEntity.noContent();
            } else {
                return ResponseEntity.ok(retrieveWatchlist);
            }
        } catch (IOException e) {
            log.error("Get Watchlist has Triggered IOException in watchlist Service Implementation", e.getMessage());
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    // returns logic for updating entries
    @Override
    public ResponseEntity<Void> updateEntry(UUID uuid, Watchlist newEntry) {

        try {
            List<Watchlist> existingWatchlist = getCurrentWatchlist();
            try {
                runUpdatingMethods.runUpdatingMethods(existingWatchlist, jsonRepo, newEntry, uuid);
            } catch (ParseException e) {
                log.error("Exception ocurred while parsing json data in watchlistServiceImplementation to update PUT request", e.getMessage());
                e.printStackTrace();
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ItemNotFoundException e) {
            log.error("Could not find item in watchlist with corresponding uuid in updateEntry method watchlist service implementation.", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            log.error("IOException has been triggered while updating entry in watchlist service implementation.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // returns logic for deleting watchlist entries
    @Override
    public ResponseEntity<List<Watchlist>> deleteWatchlistEntry(UUID uuid) throws IOException {
        List<Watchlist> existingWatchlist = getCurrentWatchlist();
        log.info("delete watchlist has been called.");
        log.info("watchlist at deleteEntry in service {}", existingWatchlist);
        try {
            
            deleteEntry.runDeleteItem(existingWatchlist, jsonRepo, mapper, uuid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InvalidInputException e) {
            log.error("Invalid input received", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ItemNotFoundException e) {
            log.error("Unable to locate requested item", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            log.error("IOException has taken place in watchlist Service implementation while attempting to run method deleteEntry", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // logic for returning sorted watchlist
    @Override
    public ResponseEntity<List<Watchlist>> sortedWatchlist() throws WatchlistDataAccessException {
            
            try {
                List<Watchlist> quickSortWatchlist = sortByName.sortedWatchlist(getCurrentWatchlist(), jsonRepo, mapper);
                return ResponseEntity.ok(quickSortWatchlist);
            } catch (IOException e) {
                log.error("IOException while attempting to sort watchlist by name.", e.getMessage());
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);            
        }
    }
}