package com.cbfacademy.apiassessment.crudActions.appendingActions.updateOneEntry;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.crudActions.appendingActions.read.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.sharedCrudMethods.ExistingWatchlistConstructor;
import com.cbfacademy.apiassessment.crudActions.appendingActions.sharedCrudMethods.NewWatchlistConstructor;
import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class UpdatePutEntry {
    
     private static final Logger log = LoggerFactory.getLogger(UpdatePutEntry.class);
    //  private ExistingEntryConstructor updateExistingEntry; removed
    //  private locatePutEntry updateWatchlist;
    //  private ReadExistingWatchlist readList;
     private ObjectMapper mapper;
     private NewWatchlistConstructor newWatchlist;
    
    @Autowired
    public UpdatePutEntry(ObjectMapper mapper, NewWatchlistConstructor newWatchlist) {
        this.mapper = mapper;
        this.mapper = mapper.registerModule(new JavaTimeModule());
        this.newWatchlist = newWatchlist;
    }

    // updates one watchlist entry located by UUID
    public void updateEntryViaUuid(List<Watchlist> existingWatchlist, UUID uuid, Watchlist newEntry){
        log.info("Locating watchlist item with UUID: {}, uuid");
        for(Watchlist watchlistEntry : existingWatchlist){
            if(watchlistEntry.getUuid().equals(uuid)){
                newWatchlist.updateOneItem(watchlistEntry, newEntry);
                log.info("Item with UUID {} has been updated in watchlist.", uuid);
                break;
            }
        }
    }
}
