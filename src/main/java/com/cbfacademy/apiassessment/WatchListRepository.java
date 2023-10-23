package com.cbfacademy.apiassessment;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WatchListRepository extends MongoRepository<WatchListModel, String> {
    
    public WatchListModel findBySymbol(String symbol);
    public List<WatchListModel> findByStockName(String stockName);
}
