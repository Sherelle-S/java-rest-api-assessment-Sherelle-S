package com.cbfacademy.apiassessment;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

// interface connects watchlist to the mongoDB database, where application is able to interact the and manipulate data.
public interface WatchlistRepository extends MongoRepository<Watchlist, String> {
    
    // public Watchlist findBySymbol(String symbol);
    // public List<Watchlist> findByStockName(String stockName);
//     public void save(WatchList watchList, int units, double profitAmount, Object pointsChange, double openingPrice,
//             double closingPrice, double intradayHigh);
}
