package com.cbfacademy.apiassessment.appendingActions;

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
    public void appendToWatchlist(List<Watchlist> watchlist, List<Watchlist> existingWatchlist) {
        for(Watchlist entry : watchlist) {
            if(!containsEntry(existingWatchlist, entry.getUuid())){
                existingWatchlist.add(entry);
            }
        }
        log.info("File append to Watchlist object.");
    }

// if we have a uuid and that uuis is the same as another already in our codebase we return true as we already have that entry.
    public boolean containsEntry(List<Watchlist> existingWatchlist, UUID uuid) {
        for (Watchlist entry : existingWatchlist){
        UUID existingUuid = entry.getUuid();
            if(existingUuid != null && entry.getUuid().equals(uuid)){
                return true;
            }
        }
        return false;
    }
}
