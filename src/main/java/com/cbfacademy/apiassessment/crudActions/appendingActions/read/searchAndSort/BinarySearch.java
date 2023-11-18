package com.cbfacademy.apiassessment.crudActions.appendingActions.read.SearchByName;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.crudActions.appendingActions.read.ReadExistingWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.sortWatchlistByName.QuicksortWatchlist;
import com.cbfacademy.apiassessment.crudActions.appendingActions.read.sortWatchlistByName.SortWatchlistByName;
import com.cbfacademy.apiassessment.model.Watchlist;

@Component
public class BinarySearch {

    private static final Logger log = LoggerFactory.getLogger(BinarySearch.class);

    @Autowired
    private QuicksortWatchlist quicksortWatchlist;

    public BinarySearch(QuicksortWatchlist quicksortWatchlist) {
            this.quicksortWatchlist = quicksortWatchlist;
        }

    public ResponseEntity<String> binarySearchWatchlist(List<Watchlist> existingWatchlist, String stockName){
        List<Watchlist> sortedWatchlist = quicksortWatchlist.sortAlgo(existingWatchlist);

        // String stockName = stockName;
        
        // for (int i = 0; i < sortedWatchlist.size(); i++){
        //     sortedWatchlist.get(i) = i;
        // }

        int index = binarySearch(sortedWatchlist, stockName);

        if(index == -1){
            log.info(stockName + " cannot be found it our watchlist.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            log.info(stockName + " found at " + index);
            return new ResponseEntity<>("Stock found at index "+ index, HttpStatus.OK);
        }

    }

    private int binarySearch(List<Watchlist> sortedWatchlist, String stockName) {
        int start = 0;
        int end = sortedWatchlist.size() - 1;

        while(start <= end) {
            int middle = start + (end - start) / 2;
            int value = sortedWatchlist.get(middle);

            if(value < stockName) {
                start = middle + 1;
            } else if(value > stockName){
                end = middle - 1;
            } else {
                return middle;
            }

    return -1;
        }

        return -1;
    }
    
}
