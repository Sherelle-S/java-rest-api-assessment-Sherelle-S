package com.cbfacademy.apiassessment.crudActions;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.SortAlgo;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.RunGetWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

// takes in an existing watchlist and returns a watchlist object sorted by name after quickort algorith,
@Component
public class SortWatchlistByName {
 
    @Autowired
    private static final Logger log = LoggerFactory.getLogger(SortWatchlistByName.class);
    private RunGetWatchlist getWatchlist;
    private SortAlgo sortAlgo;
    public Object sortedWatchlist;

    public SortWatchlistByName(RunGetWatchlist getWatchlist, SortAlgo sortAlgo) {
        this.sortAlgo = sortAlgo;
        this.getWatchlist = getWatchlist;
    }

        public List<Watchlist> sortedWatchlist(String jsonRepo, ObjectMapper mapper) throws IOException{
            try {
                List<Watchlist> existingWatchlist = getWatchlist.getWatchlist(jsonRepo, mapper);
                List<Watchlist> sortedWatchlist = sortAlgo.sortAlgo(existingWatchlist);
                return sortedWatchlist;
            } catch (IOException e) {
                log.error("IOException while sorting watchlist by name", e.getMessage());
                throw new IOException("IOException ocurred while trying to retrieving watchlist output", e);
        }
    }
}
