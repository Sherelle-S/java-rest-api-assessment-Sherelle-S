package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.Watchlist;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserWatchlist {
     public Watchlist create(Watchlist copyOfWatchlist){
        Watchlist copy = new Watchlist();
        copy.setSymbol(copyOfWatchlist.getSymbol());
        copy.setOwned(copyOfWatchlist.isOwned());
        copy.setStatus(copyOfWatchlist.getStatus());
        copy.setCurrency(copyOfWatchlist.getCurrency());
        // LocalDate date = UserInteractions.userPurchaseDate();
        copy.setDatePurchased(copyOfWatchlist.getDatePurchased());
        copy.setUnitsOwned(copyOfWatchlist.getUnitsOwned());
        copy.setProfit(copyOfWatchlist.getProfit());
        double pointsChange = copyOfWatchlist.getClose() - copyOfWatchlist.getOpen();
        copy.setPointsChange(pointsChange);
        copy.setOpen(copyOfWatchlist.getOpen());
        copy.setClose(copyOfWatchlist.getClose());
        copy.setIntradayHigh(copyOfWatchlist.getIntradayHigh());

        ObjectMapper.WriteToJson(copy);
        
        // return repository.save(copy);
    }
    
}
