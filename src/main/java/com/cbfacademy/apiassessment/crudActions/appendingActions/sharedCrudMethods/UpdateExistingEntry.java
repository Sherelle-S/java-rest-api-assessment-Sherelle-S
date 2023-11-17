package com.cbfacademy.apiassessment.crudActions.appendingActions.sharedCrudMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.model.Watchlist;

@Component
public class UpdateExistingEntry {

    // update multiple entries for when we add a new item to the watchlist
    @Autowired
    private static final Logger log = LoggerFactory.getLogger(UpdateExistingEntry.class);
    public Watchlist updateExistingEntry(Watchlist existingEntry, Watchlist newEntry){
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
        return existingEntry;
    }

    // Updates One existing entry, to be used with the PUT operations.
    @Autowired
    public Watchlist updateOneItem(Watchlist existingEntry, Watchlist newEntry){
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
}
