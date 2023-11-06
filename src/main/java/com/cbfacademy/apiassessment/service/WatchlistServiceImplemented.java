package com.cbfacademy.apiassessment.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.Watchlist;

@Service
public class WatchlistServiceImplemented implements WatchlistService {

    // @Autowired
    // private WatchlistRepository watchlistRepository;

    // List<Watchlist> list;
    // public WatchlistServiceImplemented(){
    //     list = new ArrayList<>();
    //     list.add(new Watchlist(null, null, false, null, null, null, null, 0, 0, 0, 0, 0))
    // }

    @Override
    public ResponseEntity<List<Watchlist>> getAllWatchlist() {
        List<Watchlist> watchlist = readFromJson();
        return new ResponseEntity<>(watchlist, HttpStatus.OK);
    }

    private List<Watchlist> readFromJson() {
       List<Watchlist> list;
       list = new ArrayList<>();
       list.add(new Watchlist("Gold", "XAU", true, "TestStatus", "GBP", LocalDate.now(), 100, 50.0, 2.0, 60.0, 62.0, 70.0));
    return list;
    }
    
}
