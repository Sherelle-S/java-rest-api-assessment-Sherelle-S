package com.cbfacademy.apiassessment.userInteractions;

import java.time.LocalDate;

import com.cbfacademy.apiassessment.exceptions.InvalidInputException;
import com.cbfacademy.apiassessment.model.CreateWatchlist;
import com.cbfacademy.apiassessment.model.Watchlist;

// uses the details that came from userInteractions class and converts them into usable watchlist object that can be used when in Post and put requests.
public class UserInput {
    private UserInteractions userInteractions;

    public UserInput(UserInteractions userInteractions) {
        this.userInteractions = userInteractions;
    }
    
    protected CreateWatchlist useDetails() throws InvalidInputException{
        CreateWatchlist createNewList = new CreateWatchlist(null, null);
        

        // watchList.setStockName(userInteractions.inputStockName()); we removed the setter as the property will be initialized on creation an will not be able to be edited after
        createNewList.setSymbol(userInteractions.inputSymbol());
        createNewList.setOwned(userInteractions.userOwnership());
        createNewList.setStatus(userInteractions.inputStatus());
        createNewList.setCurrency(userInteractions.userCurrency());
        LocalDate date = userInteractions.userPurchaseDate();
        createNewList.setDatePurchased(date);
        createNewList.setUnitsOwned(userInteractions.userUnits());
        createNewList.setProfit(userInteractions.userProfit());
        double pointsChange = createNewList.getClose() - createNewList.getOpen();
        createNewList.setPointsChange(pointsChange);
        createNewList.setOpen(userInteractions.openingPrice());
        createNewList.setClose(userInteractions.closingPrice());
        createNewList.setIntradayHigh(userInteractions.dailyHigh());
        userInteractions.closeScanner();

        return createNewList;
    }

}
