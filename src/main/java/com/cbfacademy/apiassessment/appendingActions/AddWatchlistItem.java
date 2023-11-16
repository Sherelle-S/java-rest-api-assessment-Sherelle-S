package com.cbfacademy.apiassessment.appendingActions;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.model.Watchlist;

// File appends data to existing temporary watchlist object
@Component
public class AddWatchlistItem {

    private static final Logger log = LoggerFactory.getLogger(AddWatchlistItem.class);
// we iterate through each item of our watchlist checking if we do not already have that uuid we add it to existingWatchlist
    public void appendToWatchlist(List<Watchlist> watchlist, List<Watchlist> existingWatchlist) {
        for(Watchlist newEntry : watchlist) {
            UUID newEntryUuid = newEntry.getUuid();
            boolean entryExists = false;

            for(Watchlist existingEntry : existingWatchlist){
                UUID existingUuid = existingEntry.getUuid();
                if(existingUuid != null && existingUuid.equals(newEntryUuid)){
                    entryExists = true;
                    updateExistingEntry(existingEntry, newEntry);
                    break;
                }
            }

            if(!entryExists){
                UUID entryUUID = UUID.randomUUID();
                newEntry.setUUID(entryUUID);
                existingWatchlist.add(newEntry);
            }
        }
        log.info("Append new entry to watchlist object.");
    }

    private void updateExistingEntry(Watchlist existingEntry, Watchlist newEntry){
        existingEntry.setStockName(newEntry.getStockName());
        existingEntry.setSymbol(newEntry.getSymbol());
        existingEntry.setHas(newEntry.getHas());
        existingEntry.setCurrency(newEntry.getCurrency());
        existingEntry.setWants(newEntry.getWants());
        // double pointsChange = existingEntry.getClose() - existingEntry.getOpen();
        existingEntry.setProfit(newEntry.getProfit());
        existingEntry.setPointsChange(newEntry.getPointsChange());
        existingEntry.setOpen(newEntry.getOpen());
        existingEntry.setClose(newEntry.getClose());
        existingEntry.setIntradayHigh(newEntry.getIntradayHigh());
    }
}

//         // if(!containsEntry(existingWatchlist, entry.getUuid())){
//                 if(entryUuid != null && containsEntry(existingWatchlist, entryUuid)) {
//                     updateExistingEntry(existingWatchlist, entry);
//                 } else { 
//                     existingWatchlist.add(entry);
//                 }
//             }
//             log.info("File append to Watchlist object.");
//         }

//         // if we have a uuid and that uuis is the same as another already in our codebase we return true as we already have that entry.
//     public boolean containsEntry(List<Watchlist> existingWatchlist, UUID uuid) {
//     // for (Watchlist entry : existingWatchlist){
//         for(Watchlist newEntry : watchlist){
//         UUID newEntryUuid = newEntry.getUuid(); 
//         boolean entryExists = false;
//         for(Watchlist existingEntry : existingWatchlist){
//             UUID existingUuid = existingEntry.getUuid();
//             if(existingUuid != null && existingUuid.equals(newEntryUuid)){
//                 entryExists = true;
//                 UUID existingUuid = existingEntry.getUuid();
//                 if(existingUuid != null && existingUuid.equals(newEntry.getUuid())){
//                 existingEntry.setStockName(newEntry.getStockName());
//                 existingEntry.setSymbol(newEntry.getSymbol());
//                 existingEntry.setHas(newEntry.getHas());
//                 existingEntry.setCurrency(newEntry.getCurrency());
//                 existingEntry.setWants(newEntry.getWants());
//                 // double pointsChange = existingEntry.getClose() - existingEntry.getOpen();
//                 existingEntry.setProfit(newEntry.getProfit());
//                 existingEntry.setPointsChange(newEntry.getPointsChange());
//                 existingEntry.setOpen(newEntry.getOpen());
//                 existingEntry.setClose(newEntry.getClose());
//                 existingEntry.setIntradayHigh(newEntry.getIntradayHigh());
//                 break;
//                 }
//             }
//                 break;
//             }
//         }

//         if(!entryExists) {
//             existingWatchlist.add(newEntry);
//         }
//     }
//     // private void updateExistingEntry(List<Watchlist> existingWatchlist, Watchlist newEntry){
//     //     for(Watchlist entry : existingWatchlist){
//     //         UUID existingUuid = entry.getUuid();
//     //         if(existingUuid != null && existingUuid.equals(newEntry.getUuid())){
//     //         entry.setStockName(newEntry.getStockName());
//     //         entry.setSymbol(newEntry.getSymbol());
//     //         entry.setHas(newEntry.getHas());
//     //         entry.setCurrency(newEntry.getCurrency());
//     //         entry.setWants(newEntry.getWants());
//     //         // double pointsChange = entry.getClose() - entry.getOpen();
//     //         entry.setProfit(newEntry.getProfit());
//     //         entry.setPointsChange(newEntry.getPointsChange());
//     //         entry.setOpen(newEntry.getOpen());
//     //         entry.setClose(newEntry.getClose());
//     //         entry.setIntradayHigh(newEntry.getIntradayHigh());
//     //         break;
//     //         }
//     //     }
//     // }




//     //         if(existingUuid != null && existingUuid.equals(uuid)){
//     //             return true;
//     //         }
//     //     }
//     //     return false;
//     // }
// // }
