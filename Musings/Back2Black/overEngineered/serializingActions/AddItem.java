package com.cbfacademy.apiassessment.serializingActions;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.deserializingActions.DeserializeWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;

@Service
public class AddItem {

    private DeserializeWatchlist deserializeWatchlist;

    public AddItem(DeserializeWatchlist deserializeWatchlist) {
        this.deserializeWatchlist = deserializeWatchlist;
    }

    public List<Watchlist> addItemToWatchlist(Watchlist newItem, String jsonRepo) throws IOException {
        try {
            List<Watchlist> existingWatchlist = deserializeWatchlist.deserializeList(jsonRepo);

            existingWatchlist.add(newItem);

            return existingWatchlist;
        } catch (Exception e) {
            throw new IOException();
        }
    
    }


    
}
