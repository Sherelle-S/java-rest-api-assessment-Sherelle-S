package com.cbfacademy.apiassessment.crudActions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.model.Watchlist;

// File appends data to existing Json File
@Component
public class AppendEntry {

    private static final Logger log = LoggerFactory.getLogger(AppendEntry.class);
    
        public void appendNewWatchlist(List<Watchlist> watchlist, List<Watchlist> existingWatchlist) {
        existingWatchlist.addAll(watchlist);
        log.info("File append to Watchlist object.");
    }
}
