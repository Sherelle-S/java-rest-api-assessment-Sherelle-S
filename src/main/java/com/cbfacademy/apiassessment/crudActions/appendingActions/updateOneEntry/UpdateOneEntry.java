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

@Component
public class UpdateOneEntry {
    
     private static final Logger log = LoggerFactory.getLogger(UpdateOneEntry.class);
     private UpdateExistingEntry updateExistingEntry;
     private UpdateWatchlist updateWatchlist;
     private ReadExistingWatchlist readList;
     private ObjectMapper mapper;
    
    @Autowired
    public UpdateOneEntry(ObjectMapper mapper, ReadExistingWatchlist readList, UpdateExistingEntry updateExistingEntry, UpdateWatchlist updateWatchlist) {
        this.updateExistingEntry = updateExistingEntry;
        this.updateWatchlist = updateWatchlist;
        this.mapper = mapper;
        this.mapper = mapper.registerModule(new JavaTimeModule());
    }

    public void updateOneViaUuid(List<Watchlist> existingWatchlist, UUID uuid, Watchlist newEntry){
        log.info("Locating watchlist item with UUID: {}, uuid");
        for(Watchlist watchlistEntry : existingWatchlist){
            if(watchlistEntry.getUuid().equals(uuid)){
                updateOneItem(watchlistEntry, newEntry);
                log.info("Item with UUID {} has been updated in watchlist.", uuid);
                break;
            }
        }
    }

    
    // Updates One existing entry, to be used with the PUT operations.
    @Autowired
    public static Watchlist updateOneItem(Watchlist existingEntry, Watchlist newEntry){
        existingEntry.setSymbol(newEntry.getSymbol());
        existingEntry.setHas(newEntry.getHas());
        existingEntry.setCurrency(newEntry.getCurrency());
        existingEntry.setWants(newEntry.getWants());
        // double pointsChange = existingEntry.getClose() - existingEntry.getOpen();
        existingEntry.setProfit(newEntry.getProfit());
        existingEntry.setPointsChange(newEntry.getPointsChange());
        existingEntry.setOpen(newEntry.getOpen());
        existingEntry.setClose(newEntry.getClose());
        existingEntry.setIntradayHigh(newEntry.getIntradayHigh());
        log.info("object with existing data has been created.");
        return newEntry;
    }
    // public List<Watchlist> updateOneEntry(UUID uuid, List<Watchlist> newEntries, String jsonRepo) throws IOException{
    //     try {
    //         List<Watchlist> existingWatchlist = readList.readExistingWatchlist(jsonRepo, mapper);
    //         for(Watchlist newEntry : newEntries){
    //             updateWatchlist.locateEntry(existingWatchlist, uuid, newEntry);
    //         }
    //         log.info("watchlist has been updates with new entries:{}", newEntries);
    //         return existingWatchlist;
    //     } catch (ItemNotFoundException e) {
    //         log.error("Item with uuid " + uuid + "could not be located.", e.getMessage());
    //         throw new IOException("Failed to locate item while running updateWatchlist method.", e);
    //     } catch (IOException e) {
    //         log.error("IOException ocurred while updating entries in watchlist", e.getMessage());
    //         throw new IOException("IOException occurred while trying to update requests");
    //     }
    // }

    // public Watchlist updateOneEntry(UUID uuid, Watchlist newEntry, String jsonRepo) throws IOException{
    //     try {
    //         List<Watchlist> existingWatchlist = readList.readExistingWatchlist(jsonRepo, mapper);
    //         updateWatchlist.locateEntry(existingWatchlist, uuid, newEntry);
    //         log.info("watchlist has been updated with new entry: {}", newEntry);
    //         return newEntry;
    //     } catch (ItemNotFoundException e) {
    //         log.error("Item with uuid" + uuid + "could not be located.", e.getMessage());
    //         throw new ItemNotFoundException("Item with the uuid " + uuid + "could not be located.");
    //     } catch (IOException e) {
    //         log.error("IOException ocurred while updating entry in watchlist", e);
    //         throw new IOException("IOException ocurred while trying to update request.");
    //     }
        

    // }
}
