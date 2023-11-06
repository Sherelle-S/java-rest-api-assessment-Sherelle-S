package com.cbfacademy.apiassessment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.WatchlistRepository;
import com.cbfacademy.apiassessment.model.Watchlist;

@Service
public class WatchlistServiceImplemented implements WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepository;

    // List<Watchlist> list;
    // public WatchlistServiceImplemented(){
    //     list = new ArrayList<>();
    //     list.add(new Watchlist(null, null, false, null, null, null, null, 0, 0, 0, 0, 0))
    // }

    @Override
    public ResponseEntity<List<Watchlist>> getAllWatchlist() {
        Iterable<Watchlist> iterableWatchlist = watchlistRepository.findAll();
        List<Watchlist> watchlist = new ArrayList<>();
        
        iterableWatchlist.forEach(watchlist::add);
        return new ResponseEntity<>(watchlist, HttpStatus.OK);
        
    }
    
}
