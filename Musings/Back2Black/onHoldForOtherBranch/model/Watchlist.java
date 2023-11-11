package com.cbfacademy.apiassessment.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Watchlist {
    private static final Map<String, Integer> stockNameIncrement = new HashMap<>();
    private final UUID id;
    private final String stockName;

    public Watchlist(UUID id, String stockName) {
        if(id == null){
            this.id = generateUUID("default");
        }else{
            this.id = id;
        }
        
        if(stockName == null){
            this.stockName = "default";
        }else{
            this.stockName = stockName;
        }
    }

    public UUID generateUUID(String stockName){
        int stockNameCount = stockNameIncrement.getOrDefault(stockName, 0);
        stockNameIncrement.put(stockName, stockNameCount + 1);
        return UUID.nameUUIDFromBytes((stockName + stockNameCount).getBytes());
    }

   public UUID getUuid() {
        return id;
    }
    public String getStockName() {
        return stockName;
    }

    @Override
    public String toString() {
        return "ImmutableWatchlist [id=" + id + ", stockName=" + stockName + "]";
    }
}
