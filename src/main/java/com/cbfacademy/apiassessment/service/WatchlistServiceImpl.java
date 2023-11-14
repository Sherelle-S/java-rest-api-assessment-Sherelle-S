package com.cbfacademy.apiassessment.service;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.controller.WatchlistController;
import com.cbfacademy.apiassessment.deserialize.DeserializeWatchlist;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.exceptions.JsonWatchlistParsingException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serialize.SerializeWatchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJsonFile;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);
    private DeserializeWatchlist deserializeList;
    private SerializeWatchlist serializeList;
    private WriteToJsonFile writeFile;


    @Autowired
    public WatchlistServiceImpl(DeserializeWatchlist deserializeList, SerializeWatchlist serializeList, WriteToJsonFile writeFile) {
        this.deserializeList = deserializeList;
        this.serializeList = serializeList;
        this.writeFile = writeFile;
    }
 

    // Handles the create part of the crud request calls methods responsible for creating a watchlist, serializing and writing it to json.
    @Override
        public ResponseEntity<WriteToJsonFile> create(Watchlist createList) throws FailedToIOWatchlistException {
        try {
            serializeList.serialize(createList);
            try {
                writeFile.writeListToJson(createList);
                // return new ResponseEntity<>(response, HttpStatus.CREATED);
                return new ResponseEntity<>(HttpStatus.CREATED);
                    } catch (InvalidInputException e) {
                log.error("Invalid input Exception triggered at watchlist service implementation.", e);
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
            }
        } catch (FailedToIOWatchlistException e) {
            log.error("IOException ocurred while writing new watchlist to json at controller.", e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // handles the Read of the crud API, responsible for reading the data from JSON file, deserializing it into a readable format.
    @Override
    // you need to read string first, then deserialize 
    public ResponseEntity<List<Watchlist>> readWatchlist() {
        try {
            List<Watchlist> watchlist = deserializeList.deserializeList();
            return ResponseEntity.ok(watchlist);
        } catch (FailedToIOWatchlistException e) {
            log.error("IOException occurred while trying to deserialize jsonWatchlist in watchlistServiceImpl", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
