package com.cbfacademy.apiassessment.controller;

import com.cbfacademy.apiassessment.Watchlist;

public class UpdateList {
    private Watchlist oldWatchlist;
    private Watchlist newWatchlist;
    
    public UpdateList(Watchlist oldWatchlist, Watchlist newWatchlist) {
        this.oldWatchlist = oldWatchlist;
        this.newWatchlist = newWatchlist;
    }

    
    /** 
     * @return Watchlist
     */
    public Watchlist getOldWatchlist() {
        return oldWatchlist;
    }

    public void setOldWatchlist(Watchlist oldWatchlist) {
        this.oldWatchlist = oldWatchlist;
    }

    public Watchlist getNewWatchlist() {
        return newWatchlist;
    }

    public void setNewWatchlist(Watchlist newWatchlist) {
        this.newWatchlist = newWatchlist;
    }

}
