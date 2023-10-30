package com.cbfacademy.apiassessment;

public class UserInput UI {
    private UserInteractions userInteractions;

    public UserInput(UserInteractions userInteractions) {
        this.userInteractions = userInteractions;
    }
    
    protected WatchList useDetails(){
        WatchList watchList = new WatchList();

        watchList.setStockName(userInteractions.inputStockName());
    }

    
}
