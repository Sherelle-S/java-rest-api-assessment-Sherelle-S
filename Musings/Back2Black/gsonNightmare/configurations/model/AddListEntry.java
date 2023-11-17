package com.cbfacademy.apiassessment.model;

import java.util.List;

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
