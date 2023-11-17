package com.cbfacademy.apiassessment.crudActions.crudInterface;

import java.util.List;

import com.cbfacademy.apiassessment.crudActions.appendingActions.AddWatchlistItem;
import com.cbfacademy.apiassessment.crudActions.appendingActions.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.UpdateAndWrite;
import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface CrudInterface {
    
    public void CreateFirstEntry(List<Watchlist> watchlist, String jsonRepo);
    public void RunCreatingActions(AddWatchlistItem addEntry, ObjectMapper mapper, ReadExistingWatchlist readList,
            UpdateAndWrite updateAndWrite);

            
}
