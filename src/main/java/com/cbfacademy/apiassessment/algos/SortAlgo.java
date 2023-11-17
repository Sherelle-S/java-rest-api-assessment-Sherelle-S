package com.cbfacademy.apiassessment;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.model.Watchlist;

@Component
public class SortAlgo {

    // private 


        public String[] sortAlgo(List<Watchlist> existingWatchlist){
            // this needs to be ammended so stockName is an array that is populated with all stockNames from all of the json inputs
        String[]stockNames = new String[existingWatchlist.size()];//number of items in the arrayList
        for(int i = 0; i < existingWatchlist.size(); i++){
            stockNames[i] = existingWatchlist.get(i).getStockName();
            // populate the array with a list of stockNames mapped from the json Objects.
        }
        // int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};
            quickSort(stockNames, 0, stockNames.length - 1);
            for(String name : stockNames){
                System.out.println(name);
            }
            return stockNames;
        }
        private static void quickSort(String[] stockNames, int start, int end){
            if(end <= start) return; //base case
            int pivotIndex = partition(stockNames, start, end);

            quickSort(stockNames, start, pivotIndex - 1);
            quickSort(stockNames, pivotIndex + 1, end);
        }
        private static int partition(String[] stockNames, int start, int end){
            String pivot = stockNames[end];
            int i = start -1;
            for(int j = start; j < end - 1; j++){
                if(stockNames[j].compareTo(pivot) < 0) {
                    i++;
                    String temp = stockNames[i];
                    stockNames[i] = stockNames[j];
                    stockNames[j] = temp;
                }
            }
            // i++;
            String temp = stockNames[i + 1];
                    stockNames[i + 1] = stockNames[end];
                    stockNames[end] = temp;
        return i + 1;
    }
}
