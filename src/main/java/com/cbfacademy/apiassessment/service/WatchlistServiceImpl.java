package com.cbfacademy.apiassessment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.controller.WatchlistController;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.cbfacademy.apiassessment.serialize.SerializeWatchlist;
import com.cbfacademy.apiassessment.serialize.WriteToJsonFile;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);
    private SerializeWatchlist serializeList;
    private WriteToJsonFile writeFile;

    @Autowired
    public WatchlistServiceImpl(SerializeWatchlist serializeList, WriteToJsonFile writeFile) {
        this.serializeList = serializeList;
        this.writeFile = writeFile;
    }

    @Override
    public ResponseEntity<WriteToJsonFile> create(CreateWatchlist createList) throws FailedToIOWatchlistException {
        try {
            serializeList.formatWatchlist(createList);
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
            log.error("FIOException ocurred while writing new watchlist to json at controller.", e);
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
