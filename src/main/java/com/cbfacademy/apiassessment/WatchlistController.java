package com.cbfacademy.apiassessment;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatchlistController {

    // Get method
    // use localhost 8080 to return the page
    // localhost:8080/watchlist

    @GetMapping("/ShowWatchlist")
    // here we the method is the watchlistModel Bean
    // This data must be written to a JSON file and the data should append the data on each post request.
    // json data should be rendered in an algo format of search or sort.
    // create a file that writes to JSON
    public WatchList getWatchlist(){
        return new WatchList(
            "Silver",
        	"SLV",
        	true,
        	"Hold",
        	"GBP",
        	LocalDate.of(2018, Month.JUNE, 15),
        	600,
        	.95,
        	1.38,
        	2.287,
        	1.237,
        	2.912);
    }

    @GetMapping("/ShowWatchlists")
    public List<WatchList> getWatchlists(){

        List<WatchList> watchlist = new ArrayList<>();
        watchlist.add(new WatchList(
            "American Dollars", 
            "USD", 
            true, 
            null, 
            "USD",
            LocalDate.of( 2021, Month.AUGUST, 10), 
            1520, 
            0.5, 
            1.20, 
            10, 
            11, 
            12));
            watchlist.add(new WatchList(
            "Silver",
        	"SLV",
        	true,
        	"Hold",
        	"GBP",
        	LocalDate.of(2018, Month.JUNE, 15),
        	600,
        	.95,
        	1.38,
        	2.287,
        	1.237,
        	2.912));
            return watchlist;
        
    }
    
}
