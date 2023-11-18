package com.cbfacademy.apiassessment.crudActions.crudInterface;

import java.util.List;
import java.util.UUID;

import com.cbfacademy.apiassessment.crudActions.appendingActions.createEntry.AddWatchlistItem;
import com.cbfacademy.apiassessment.crudActions.appendingActions.deleteEntries.DeleteEntry;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.sharedCrudMethods.WriteToJsonFile;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface CrudInterface {
    
    public void CreateFirstEntry(List<Watchlist> watchlist, String jsonRepo);
    public void RunCreatingActions(AddWatchlistItem addEntry, ObjectMapper mapper, ReadExistingWatchlist readList,
            WriteToJsonFile writeToJson);
    public void runUpdatingMethods(List<Watchlist> watchlist, String jsonRepo, Watchlist newEntry, UUID uuid) 
    public void RunDeleteEntry(DeleteEntry deleteEntry, ReadExistingWatchlist readList)
;}
