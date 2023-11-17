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
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.RunGetWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.updateOneEntry.RunUpdatingMethods;
import com.cbfacademy.apiassessment.crudActions.appendingActions.updateOneEntry.UpdateOneEntry;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
@Component
public class WatchlistServiceImpl implements WatchlistService {

    String jsonRepo = "JsonWatchlist.json";

    @Autowired
    private CreateFirstItem createFirstItem;
    private UpdateOneEntry updateOneEntry;
    private RunDeleteEntry deleteEntry;
    private ObjectMapper mapper;
    private RunCreatingActions runCreateItem;
    private RunGetWatchlist getWatchlist;
    private RunUpdatingMethods runUpdatingMethods;
    


    public WatchlistServiceImpl(CreateFirstItem createFirstItem, ObjectMapper mapper,
            RunCreatingActions runCreateItem, RunDeleteEntry deleteEntry, RunGetWatchlist getWatchlist, RunUpdatingMethods runUpdatingMethods, UpdateOneEntry updateOneEntry) {
        this.createFirstItem = createFirstItem;
        this.mapper = mapper;
        this.mapper = mapper.registerModule(new JavaTimeModule());
        this.runCreateItem = runCreateItem;
        this.deleteEntry = deleteEntry;
        this.getWatchlist = getWatchlist;
        this.runUpdatingMethods = runUpdatingMethods;
        this.updateOneEntry = updateOneEntry;
    }

    private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);

    @Override
    public ResponseEntity<Void> create(List<Watchlist> watchlist) throws FailedToIOWatchlistException {
        // List<Watchlist> existingWatchlist = new ArrayList<>();
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
                // existingWatchlist = getExistingWatchlist();
                runCreateItem.appendNewItems(watchlist, jsonRepo);
                return new ResponseEntity<>(HttpStatus.CREATED);
                //  addWatchlistEntry(existingWatchlist);
            }
        } catch (Exception e) {
            log.error("Error processing file: " + e.getMessage());
            // throw new FailedToIOWatchlistException("Failed to create or process the file");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Watchlist>> readWatchlist() {
        try {
            List<Watchlist> retrieveWatchlist = getWatchlist.getWatchlist(jsonRepo, mapper);
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

    @Override
    public ResponseEntity<Void> updateEntry(UUID uuid, Watchlist newEntry) {

        try {
            List<Watchlist> existingWatchlist = getWatchlist.getWatchlist(jsonRepo, mapper);
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

    @Override
    public ResponseEntity<List<Watchlist>> deleteWatchlistEntry(UUID uuid) throws IOException {
        List<Watchlist> existingWatchlist = getWatchlist.getWatchlist(jsonRepo, mapper);
        log.info("delete watchlist has been called.");
        log.info("watchlist at deleteEntry in service {}", existingWatchlist);
        try {
            
            deleteEntry.runDeleteItem(existingWatchlist, jsonRepo, mapper, uuid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            log.error("Unable to locate requested item", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            log.error("IOException has taken place in watchlist Service implementation while attempting to run method deleteEntry", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}