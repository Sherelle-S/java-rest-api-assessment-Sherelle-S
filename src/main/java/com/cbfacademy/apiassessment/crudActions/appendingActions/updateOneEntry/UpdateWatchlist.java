package com.cbfacademy.apiassessment.crudActions.appendingActions.updateOneEntry;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.crudActions.appendingActions.read.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.sharedCrudMethods.UpdateExistingEntry;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// updates an item in the watchlist after finding its uuid. uses helper method updateExistingEntry.updateOneItem to update the specific entry once it is found.
@Component
public class UpdateWatchlist {

    private static final Logger log = LoggerFactory.getLogger(UpdateWatchlist.class);

    @Autowired
    private ObjectMapper mapper;
    private ReadExistingWatchlist readList;
    private UpdateExistingEntry updateExistingEntry;
    
    public UpdateWatchlist(ObjectMapper mapper, ReadExistingWatchlist readList, UpdateExistingEntry updateExistingEntry) {
        this.mapper = mapper;
        this.mapper = mapper.registerModule(new JavaTimeModule());
        this.readList = readList;
        this.updateExistingEntry = updateExistingEntry;

    }

    public void locateEntry(List<Watchlist> existingWatchlist, UUID uuid, Watchlist newEntry){
        log.info("locating watchlist item");
        for(Watchlist watchlistEntry : existingWatchlist) {
            if(watchlistEntry.getUuid().equals(uuid)){
                updateExistingEntry.updateOneItem(watchlistEntry, newEntry);
                log.info("Item with uuid" + uuid + "has been updated in watchlist: {}", uuid);
                break;
            }
        }
    }
}
