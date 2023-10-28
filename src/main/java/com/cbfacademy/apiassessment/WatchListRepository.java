package com.cbfacademy.apiassessment;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WatchListRepository extends MongoRepository<WatchList, String> {
    
    public WatchList findBySymbol(String symbol);
    public List<WatchList> findByStockName(String stockName);
//     public void save(WatchList watchList, int units, double profitAmount, Object pointsChange, double openingPrice,
//             double closingPrice, double intradayHigh);
}
