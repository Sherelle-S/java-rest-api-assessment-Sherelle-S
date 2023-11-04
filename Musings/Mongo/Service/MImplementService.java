package com.cbfacademy.apiassessment.Mongo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.Mongo.MongoWatchlistRepository;
import com.cbfacademy.apiassessment.model.Watchlist;

@Service
public class MImplementService implements MWatchlistService{

    private MongoWatchlistRepository watchlistRepository;

    @Autowired
    public MImplementService(MongoWatchlistRepository watchlistRepository){
        super();
        this.watchlistRepository = watchlistRepository;
    }

    @Override
    public Watchlist saveWatchlist(Watchlist watchlist) {
        return watchlistRepository.save(watchlist);
    }

    
}
