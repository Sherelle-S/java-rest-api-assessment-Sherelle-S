package com.cbfacademy.apiassessment.crudActions;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.crudActions.appendingActions.AddWatchlistItem;
import com.cbfacademy.apiassessment.crudActions.appendingActions.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.UpdateAndWrite;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// Responsible to controlling the components that append a new entry to the json file it reads old watchlist from json, converts it into a new watchlist object, appends an new entry and returns it back to the json file with new entry added.
@Component 
public class RunCreatingActions {

    private static final Logger log = LoggerFactory.getLogger(RunCreatingActions.class);

    private AddWatchlistItem addEntry;
    private ObjectMapper mapper;
    private ReadExistingWatchlist readList;
    private UpdateAndWrite updateAndWrite;

    @Autowired
       public RunCreatingActions(AddWatchlistItem addEntry, ObjectMapper mapper, ReadExistingWatchlist readList,
            UpdateAndWrite updateAndWrite) {
        this.addEntry = addEntry;
        this.mapper = mapper;
        this.mapper = mapper.registerModule(new JavaTimeModule());
        this.readList = readList;
        this.updateAndWrite = updateAndWrite;
    }

    public ResponseEntity<?> appendNewItems(@RequestBody List<Watchlist> watchlist, String jsonRepo) throws IOException{
        try {
            List<Watchlist> existingWatchlist = readList.readExistingWatchlist(jsonRepo, mapper);
            List<Watchlist> updatedWatchlist = addEntry.appendToWatchlist(watchlist, existingWatchlist);
            updateAndWrite.writeUpdatedWatchlist(jsonRepo, mapper, updatedWatchlist);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (JacksonException e) {
            log.error("Exception while trying to process json request with jackson", e.getMessage());
            return new ResponseEntity<>("Error processing JSON.", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            log.error("Exception occurred while running Appending components to watchlist");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            // throw new FailedToIOWatchlistException("IOException ocurred while running appendWatchlist method.", e.getMessage());
        }
    }
}
//    public void runAppendingActions(List<Watchlist> watchlist, String jsonRepo) throws IOException{

    //     try {
    //         List<Watchlist> existingWatchlist = readList.readExistingWatchlist(jsonRepo, mapper);
    //         for(Watchlist entry : watchlist){
    //             if(!addEntry.containsEntry(existingWatchlist, entry.getUuid()))
    //             log.isDebugEnabled();
    //             existingWatchlist.add(entry);
    //             log.info("uuid in run appending actions is " + entry.getUuid());
    //         }
    //         log.info("ExistingWatchlist in AppendWatchlist: {}", existingWatchlist);
    //         // addEntry.appendNewWatchlist(watchlist, existingWatchlist);
    //         addEntry.appendToWatchlist(watchlist, existingWatchlist);
    //         updateAndWrite.writeUpdatedWatchlist(jsonRepo, mapper, existingWatchlist);
    //     } catch (JacksonException e) {
    //         log.error("Exception while trying to process json request with jackson", e.getMessage());
    //         throw new JsonWatchlistParsingException("Exception ocurred while trying to parse json file.", e.getMessage());
    //     } catch (IOException e) {
    //         log.error("Exception occurred while running Appending components to watchlist");
    //         throw new FailedToIOWatchlistException("IOException ocurred while running appendWatchlist method.", e.getMessage());
    //     }
    // }