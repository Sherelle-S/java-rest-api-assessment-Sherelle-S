package com.cbfacademy.apiassessment.service;

import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;

@Component
public class UserWatchlist {
     public CreateWatchlist create(CreateWatchlist copyOfWatchlist){
        CreateWatchlist copy = new CreateWatchlist(null, null);
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

        return copy;
        
        // return repository.save(copy);
    }
    
}
