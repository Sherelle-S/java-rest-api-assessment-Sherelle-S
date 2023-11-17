package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cbfacademy.apiassessment.service.WatchlistService;
import com.fasterxml.jackson.databind.ObjectMapper;
// creates a list out of input from http request so it can be serialized to json
public class AddListEntry {
    
    private List<Watchlist> newEntry;

    // @JsonC
    public List<Watchlist> getNewEntry() {
        return newEntry;
    }

    public void setNewEntry(List<Watchlist> newEntry) {
        this.newEntry = newEntry;
    }

}
