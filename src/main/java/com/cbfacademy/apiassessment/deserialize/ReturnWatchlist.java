package com.cbfacademy.apiassessment.deserialize;

import com.cbfacademy.apiassessment.model.CreateWatchlist;

public class ReturnWatchlist {
    
    public CreateWatchlist returnJava(CreateWatchlist createWatchlist){

        createWatchlist.getUuid(set);
        createWatchlist.getStockName();
        createWatchlist.getSymbol();
        createWatchlist.isOwned();
        createWatchlist.getStatus();
        createWatchlist.getCurrency();
        createWatchlist.getDatePurchased();
        createWatchlist.getUnitsOwned();
        createWatchlist.getProfit();
        createWatchlist.getPointsChange();
        createWatchlist.getOpen();
        createWatchlist.getClose();
        createWatchlist.getIntradayHigh();
        return createWatchlist;
    }
    
}
