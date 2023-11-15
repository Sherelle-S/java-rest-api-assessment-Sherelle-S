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
    
        public void appendNewWatchlist(List<Watchlist> watchlist, List<Watchlist> existingWatchlist) {
            for(Watchlist entry : watchlist) {
                if(!containsEntry(existingWatchlist, entry.getUuid())){
                    existingWatchlist.add(entry);
                }
            }
        log.info("File append to Watchlist object.");
    }

    private boolean containsEntry(List<Watchlist> existingWatchlist, UUID uuid) {
        for (Watchlist entry : existingWatchlist){
            if(entry.getUuid() != null && entry.getUuid().equals(uuid)){
                return true;
            }
        }
        return false;
    }
}
