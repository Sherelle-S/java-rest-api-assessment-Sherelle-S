package com.cbfacademy.apiassessment.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import com.cbfacademy.apiassessment.exceptions.FailedToIOWatchlistException;
import com.cbfacademy.apiassessment.model.Watchlist;

public interface WatchlistService {

    ResponseEntity<Void> create(List<Watchlist> watchlist) throws FailedToIOWatchlistException;

    ResponseEntity<List<Watchlist>> readWatchlist() throws FailedToIOWatchlistException;

    // ResponseEntity <Void> updateEntry(Watchlist watchlist, UUID uuid);
    ResponseEntity<Void> updateEntry(UUID uuid, Watchlist newEntry);

    ResponseEntity<List<Watchlist>> deleteWatchlistEntry(UUID uuid) throws IOException;

    // ResponseEntity<Void> update(Watchlist watchlist);

} 
