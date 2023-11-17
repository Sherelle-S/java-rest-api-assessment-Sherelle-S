package com.cbfacademy.apiassessment.crudActions;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.crudActions.appendingActions.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SortWatchlistByName {

    private ReadExistingWatchlist readList;

    public SortWatchlistByName(ReadExistingWatchlist readList) {
        this.readList = readList;
    }

    private static final Logger log = LoggerFactory.getLogger(SortWatchlistByName.class);

        public List<Watchlist> sorWatchlistsByName(String jsonRepo, ObjectMapper mapper){
        try {
            List<Watchlist> watchlist = readList.readExistingWatchlist(jsonRepo, mapper);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}
