package com.cbfacademy.apiassessment;

import java.time.LocalDate;

import com.cbfacademy.apiassessment.Exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.model.Watchlist;

// uses the details that came from userInteractions class and converts them into usable watchlist object that can be used when in Post and put requests.
public class UserInput {
    private UserInteractions userInteractions;

    public UserInput(UserInteractions userInteractions) {
        this.userInteractions = userInteractions;
    }
    
    
    /** 
     * @return Watchlist
     * @throws InvalidInputException
     */
    protected Watchlist useDetails() throws InvalidInputException{
        Watchlist watchList = new Watchlist();
        

        watchList.setStockName(userInteractions.inputStockName());
        watchList.setSymbol(userInteractions.inputSymbol());
        watchList.setOwned(userInteractions.userOwnership());
        watchList.setStatus(userInteractions.inputStatus());
        watchList.setCurrency(userInteractions.userCurrency());
        LocalDate date = userInteractions.userPurchaseDate();
        watchList.setDatePurchased(date);
        watchList.setUnitsOwned(userInteractions.userUnits());
        watchList.setProfit(userInteractions.userProfit());
        double pointsChange = watchList.getClose() - watchList.getOpen();
        watchList.setPointsChange(pointsChange);
        watchList.setOpen(userInteractions.openingPrice());
        watchList.setClose(userInteractions.closingPrice());
        watchList.setIntradayHigh(userInteractions.dailyHigh());
        userInteractions.closeScanner();

        return watchList;
    }

}
