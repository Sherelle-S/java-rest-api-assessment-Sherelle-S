package com.cbfacademy.apiassessment.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.controller.WatchlistController;
import com.cbfacademy.apiassessment.crudActions.CreateFirstItem;
import com.cbfacademy.apiassessment.crudActions.RunCreatingActions;
import com.cbfacademy.apiassessment.crudActions.RunGetWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
@Component
public class WatchlistServiceImpl implements WatchlistService {

    String jsonRepo = "JsonWatchlist.json";
    @Autowired
    private CreateFirstItem createFirstItem;
    private ObjectMapper mapper;
    private ReadExistingWatchlist readJsonWatchlist;
    private RunCreatingActions runCreateItem;
    private RunGetWatchlist getWatchlist;


    public WatchlistServiceImpl(CreateFirstItem createFirstItem, ObjectMapper mapper,
            ReadExistingWatchlist readJsonWatchlist, RunCreatingActions runCreateItem, RunGetWatchlist getWatchlist) {
        this.createFirstItem = createFirstItem;
        this.mapper = mapper;
        this.mapper = mapper.registerModule(new JavaTimeModule());
        this.readJsonWatchlist = readJsonWatchlist;
        this.runCreateItem = runCreateItem;
        this.getWatchlist = getWatchlist;
    }



    private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);
 

    @Override
    public ResponseEntity<Void> create(List<Watchlist> watchlist) throws FailedToIOWatchlistException {
        List<Watchlist> existingWatchlist = new ArrayList<>();
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
            return ResponseEntity.ok(retrieveWatchlist);
        } catch (IOException e) {
            log.error("Get Watchlist has Triggered IOException in watchlist Service Implementation", e.getMessage());
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}




   
    
    // @Override
    // public ResponseEntity<List<Watchlist>> readWatchlist() throws JsonWatchlistParsingException, ParseException {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'readWatchlist'");
    // }
// }
    // private RunAppendingActions runAppend;
    // private DeserializeWatchlist deserializeList;
    // // private RunUpdatingActivities runUpdate;
    // private SerializeWatchlist serializeList;
    // private WriteToJsonFile writeFile;
    // // private UuidViaName uuidViaName;

    // @Autowired
    // // public WatchlistServiceImpl( , RunUpdatingActivities runUpdate, SerializeWatchlist serializeList, WriteToJsonFile writeFile, UuidViaName uuidViaName) {
    //     public WatchlistServiceImpl(RunAppendingActions runAppend, DeserializeWatchlist deserializeList, SerializeWatchlist serializeList, WriteToJsonFile writeFile) {
    //     this.deserializeList = deserializeList;
    //     this.runAppend = runAppend;
    //     this.serializeList = serializeList;
    //     this.writeFile = writeFile;
    //  }

    // String jsonRepo = "src/main/resources/JsonWatchlist.json";
 
    // // gets an object of existing watchlsts
    // private List<Watchlist> getExistingWatchlist() throws FailedToIOWatchlistException {
    //     try {
    //         return deserializeList.deserializeList(jsonRepo);
    //     } catch (FailedToIOWatchlistException e) {
    //         log.error("IOException occurred while trying to deserialize jsonWatchlist in watchlistServiceImpl", e.getMessage());
    //         throw e;
    //     }
    // }

    // // Handles the create part of the crud request calls methods responsible for creating a watchlist, serializing and writing it to json.
    // public ResponseEntity<WriteToJsonFile> createNewList(List<Watchlist> createList) throws FailedToIOWatchlistException {
    //     try {
    //     serializeList.serialize(createList);
    //         try {
    //             writeFile.writeListToJson(createList, jsonRepo);
    //             // return new ResponseEntity<>(response, HttpStatus.CREATED);
    //             return new ResponseEntity<>(HttpStatus.CREATED);
    //         } catch (InvalidInputException e) {
    //             log.error("Invalid input Exception triggered at watchlist service implementation.", e.getMessage());
    //             e.printStackTrace();
    //             return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    //         }
    //     } catch (FailedToIOWatchlistException e) {
    //         log.error("IOException ocurred while writing new watchlist to json at controller.", e.getMessage());
    //         e.printStackTrace();
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // public ResponseEntity<String> addWatchlistEntry(List<Watchlist> existingWatchlist){
    //     try {
    //         runAppend.runAppendingActions(existingWatchlist, jsonRepo);
    //         return new ResponseEntity<>(HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         log.error("Failed to append new watchlist entry to Json in watchlist service implementation", e.getMessage());
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }

    // // handles the create part of the CRUD request
    //    @Override
    //    public ResponseEntity<Void> create(List<Watchlist> createList) throws FailedToIOWatchlistException {
    //     try {
    //         File file = new File(jsonRepo);
    //         if (!file.exists() || file.length() == 0) {
    //             createNewList(createList);
    //             return new ResponseEntity<>(HttpStatus.CREATED);
    //         } else {
    //             List<Watchlist> existingWatchlist = getExistingWatchlist();
    //             log.info("existing has been retrieved");
    //             ResponseEntity<String> addEntryResponse = addWatchlistEntry(existingWatchlist);
            
    //             if (addEntryResponse.getStatusCode() == HttpStatus.CREATED) {
    //                 return new ResponseEntity<>(HttpStatus.CREATED);
    //             } else {
    //                 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //             }
    //         }
    //     } catch (IOException e) {
    //        log.error("IOException ocurred while trying to create watchlist", e.getMessage());
    //        throw new FailedToIOWatchlistException();
    //     } 
    // }

    // // handles the Read of the crud API, responsible for reading the data from JSON file, deserializing it into a readable format.
    // @Override
    // // you need to read string first, then deserialize 
    // public ResponseEntity<List<Watchlist>> readWatchlist() {
    //     try {
    //         List<Watchlist> watchlist = deserializeList.deserializeList(jsonRepo);
    //         return ResponseEntity.ok(watchlist);
    //     } catch (FailedToIOWatchlistException e) {
    //         log.error("IOException occurred while trying to deserialize jsonWatchlist in watchlistServiceImpl", e.getMessage());
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    


    // @Override
    // public ResponseEntity<Void> updateListByName() throws ItemNotFoundException {
    //    try {
    //     if(updateByName()){
    //     uuidViaName.findUUID(getExistingWatchlist(), stockName);
    //    }
    //    } catch (FileNotFoundException e) {
    //     log.error("Could not find " + stockName + " in the existing watchlist.", e);
    //     throw new ItemNotFoundException(stockName + "is not currently registered in database.", e);
    //    } catch (IOException e){
    //     log.error("IOException triggered while attempting to pair stockname with UUID", e);
    //     throw new IOException(e);
    //    }
        
    // }
// }
