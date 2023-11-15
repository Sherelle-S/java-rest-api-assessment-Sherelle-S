// package com.cbfacademy.apiassessment.updateItem;

// import java.util.List;
// import java.util.UUID;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;

// import com.cbfacademy.apiassessment.updateItem.UuidViaName;otFoundException;
// import com.cbfacademy.apiassessment.model.Watchlist;

// // since the trading algo will only hold one item of each stockName we are able to search by name to find the items uuid.
// @Component
// public class UuidViaName {

//     private static final Logger log = LoggerFactory.getLogger(UuidViaName.class);

//     // deserialize json file to existing list
//     // locate item name and pair it with UUID
//     // return UUID for item to be deleted or updated

//     public UUID findUUID(List<Watchlist> existingWatchlist, String stockName) {

//         // UUID stockNameId = null;

//         // try {
//         //     for (Watchlist watchlist : existingWatchlist) {
//         //         if("stockName".equalsIgnoreCase(watchlist.getStockName())){
//         //             stockNameId = watchlist.getUuid();
//         //             break;
//         //         }
//         //     }

//         //     if(stockNameId != null){
//         //     return stockNameId;
//         //     } 
//         // } catch (ItemNotFoundException e) {
//         //     log.error("item with this stockName can not be found in watchlist.", e.getMessage());
//         //     throw new ItemNotFoundException("Item cannot be found at find uuid.");
//         // }
//         // return stockNameId;
//     // }
// }
