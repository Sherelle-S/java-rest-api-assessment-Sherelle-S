// // package com.cbfacademy.apiassessment;

// // import java.util.List;

// // import org.springframework.stereotype.Component;

// // import com.cbfacademy.apiassessment.model.Watchlist;

// // // we use this sorting algorythm to sort our retunred json data by name.
// // @Component
// // public class SortAlgo {

//         public List<Watchlist> sortAlgo(@RequestBody List<Watchlist> existingWatchlist){
//             // this needs to be ammended so stockName is an array that is populated with all stockNames from all of the json inputs
//         quickSort(existingWatchlist, 0, existingWatchlist.size() - 1);//number of items in the arrayList
//         for(Watchlist watchlist : existingWatchlist) {
//             System.out.println(watchlist.getStockName());
//             // stockNames[i] = existingWatchlist.get(i).getStockName();
//             // populate the array with a list of stockNames mapped from the json Objects.
//         }
//             // quickSort(stockNames, 0, stockNames.length - 1);
//             // for(String name : stockNames){
//             //     System.out.println(name);
//             // }
//             // return stockNames;
//             return existingWatchlist;
//         }
//         private static void quickSort(List<Watchlist> watchlist, int start, int end){
//             if(end <= start) return; //base case
//             int pivotIndex = partition(watchlist, start, end);

//             quickSort(watchlist, start, pivotIndex - 1);
//             quickSort(watchlist, pivotIndex + 1, end);
//         }

//         private static int partition(List<Watchlist> watchlist, int start, int end){
//             String pivot = watchlist.get(end).getStockName();
//             int i = start -1;
//             for(int j = start; j < end - 1; j++){
//                 if(watchlist.get(j).getStockName().compareTo(pivot) < 0) {
//                     i++;
//                     Watchlist temp = watchlist.get(i);
//                     watchlist.set(i, watchlist.get(j));
//                     watchlist.set(j, temp);
//                 }
//             }
//             // i++;
//             Watchlist temp = watchlist.get(i + 1);
//             watchlist.set(i + 1, watchlist.get(end));
//             watchlist.set(end, temp);
//         return i + 1;
//     }
// }
