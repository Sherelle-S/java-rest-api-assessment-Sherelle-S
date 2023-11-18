package com.cbfacademy.apiassessment.crudActions.appendingActions.read.sortWatchlistByName;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.model.Watchlist;

// we use this sorting algorithm to sort our returned json data by name.
@Component
public class QuicksortWatchlist {

        public List<Watchlist> sortAlgo(List<Watchlist> existingWatchlist){
        quickSort(existingWatchlist, 0, existingWatchlist.size() - 1);
        for(Watchlist watchlist : existingWatchlist) {
            System.out.println(watchlist.getStockName());
        }
            return existingWatchlist;
        }
        private static void quickSort(List<Watchlist> watchlist, int start, int end){
            if(end <= start) return; //base case
            int pivotIndex = partition(watchlist, start, end);

            quickSort(watchlist, start, pivotIndex - 1);
            quickSort(watchlist, pivotIndex + 1, end);
        }

        private static int partition(List<Watchlist> watchlist, int start, int end){
            String pivot = watchlist.get(end).getStockName();
            int i = start -1;
            for(int j = start; j <= end - 1; j++){
                if(watchlist.get(j).getStockName().compareTo(pivot) < 0) {
                    i++;
                    Watchlist temp = watchlist.get(i);
                    watchlist.set(i, watchlist.get(j));
                    watchlist.set(j, temp);
                }
            }
            Watchlist temp = watchlist.get(i + 1);
            watchlist.set(i + 1, watchlist.get(end));
            watchlist.set(end, temp);
        return i + 1;
    }
}
