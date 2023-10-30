package com.cbfacademy.apiassessment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.Watchlist;
import com.cbfacademy.apiassessment.WatchlistRepository;

@Service
public class ImplementService implements WatchListService{

    private WatchlistRepository watchListRepository;

    @Autowired
    public ImplementService(WatchlistRepository watchlistRepository){
        super();
        this.watchlistRepository = watchlistRepository;
    }

    @Override
    public Watchlist saveWatchlist(Watchlist watchlist) {
        return watchListRepository.save(watchlist);
    }

    
}
