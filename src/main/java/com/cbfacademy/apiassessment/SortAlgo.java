package com.cbfacademy.apiassessment;

import com.cbfacademy.apiassessment.model.Watchlist;

public class SortAlgo {

//     public void sortAlgo(List<Watchlist> existingWatchlist){
//         // this needs to be ammended so stockName is an array that is populated with all stockNames from all of the json inputs
//     String[]stockName = new String[existingWatchlist.size()];//number of items in the arrayList
//     for(int i = 0; i < existingWatchlist.length; i++){
//         stockName[i] = existingWatchlist[i];
//         // populate the array with a list of stockNames mapped from the json Objects.
//     }
//     // int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};
//         quickSort(stockName, 0, stockName.length - 1);
//         for(int i : stockName){
//             System.out.println(i  + " ");
//         }
//     private static void quickSort(String[] stockName, int start, int end){
//         if(end <= start) return; //base case
//         int pivot = partition(stockName, start, end);

//         quickSort(stockName, start, pivot - 1);
//         quickSort(stockName, pivot + 1, end);
//     }
//      private static int partition(int[] stockName, int start, int end){
//         int pivot = stockName[end];
//         int i = start -1;
//         for(int j = start; j <= end - 1; j++){
//             if(stockName[j] < pivot) {
//                 i++;
//                 int temp = stockName[i];
//                 stockName[i] = stockName[j];
//                 stockName[j] = temp;
//             }
//         }
//         i++;
//         int temp = stockName[i];
//                 stockName[i] = stockName[end];
//                 stockName[end] = temp;
//      return i;
// }
// }
}
