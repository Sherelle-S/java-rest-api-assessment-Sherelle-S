package com.cbfacademy.apiassessment.crudActions.appendingActions;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.model.Watchlist;

// File appends data to existing temporary watchlist object
@Component
public class AddWatchlistItem {

    private static final Logger log = LoggerFactory.getLogger(AddWatchlistItem.class);
// we iterate through each item of our watchlist checking if we do not already have that uuid we add it to existingWatchlist
    public List<Watchlist> appendToWatchlist(@RequestBody List<Watchlist> watchlist, List<Watchlist> existingWatchlist) {
        log.info("watchlist when append to watchlist begins existing uuid: {}", watchlist);
        for(Watchlist newEntry : watchlist) {
            UUID newEntryUuid = newEntry.getUuid();
            boolean entryExists = false;

            for(Watchlist existingEntry : existingWatchlist){
                UUID existingUuid = existingEntry.getUuid();
                if(existingUuid != null && existingUuid.equals(newEntryUuid)){
                    entryExists = true;
                    updateExistingEntry(existingEntry, newEntry);
                    log.info("existingWatchlist at if existing uuid addWatchlist: {}", existingWatchlist);
                    log.info("watchlist at existing uuid: {}", watchlist);
                    break;
                }
            }

            if(!entryExists){
                UUID entryUUID = UUID.randomUUID();
                newEntry.setUuid(entryUUID);
                existingWatchlist.add(newEntry);
                log.info("existingWatchlist at !entryExists addWatchlistItem: {}", existingWatchlist);
            }
        }
        log.info("Append new entry to watchlist object.");
        return existingWatchlist;
    }

    private void updateExistingEntry(Watchlist existingEntry, Watchlist newEntry){
        existingEntry.setStockName(newEntry.getStockName());
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
    }
}