package com.cbfacademy.apiassessment.crudActions.appendingActions.read.searchAndSort;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.exceptions.ItemNotFoundException;
import com.cbfacademy.apiassessment.model.Watchlist;

// uses binary search to find watchlist object by name.
@Component
public class BinarySearch {

    private static final Logger log = LoggerFactory.getLogger(BinarySearch.class);

    @Autowired
    private QuicksortWatchlist quicksortWatchlist;

    public BinarySearch(QuicksortWatchlist quicksortWatchlist) {
            this.quicksortWatchlist = quicksortWatchlist;
        }

    public Watchlist binarySearchWatchlist(List<Watchlist> existingWatchlist, String name){
        List<Watchlist> sortedWatchlist = quicksortWatchlist.sortAlgo(existingWatchlist);

        int index = binarySearch(sortedWatchlist, name);
        log.info("pre search name is" + name );

        if(index == -1){
            log.info(name + " cannot be found it our watchlist.");
            throw new ItemNotFoundException(name + "Cannot be found in Watchlist");
        } else {
            log.info(name + " found at " + index);
            // return new ResponseEntity<>(sortedWatchlist.get(index), HttpStatus.OK);
            return existingWatchlist.get(index);
        }
    }

    private int binarySearch(List<Watchlist> sortedWatchlist, String name) {
        log.info("Binary search operation is taking place");
        int start = 0;
        int end = sortedWatchlist.size() - 1;
        String searchName = name.toLowerCase();

        while(start <= end) {
            int middle = start + (end - start) / 2;
            String value = sortedWatchlist.get(middle).getStockName().toLowerCase();
            int checkResult = value.compareTo(searchName);
            if(checkResult < 0) {
                start = middle + 1;
            } else if(checkResult > 0){
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
