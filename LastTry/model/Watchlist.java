package com.cbfacademy.apiassessment.model;

import java.util.HashMap;
import java.util.Map;
// import java.util.UUID;

public class Watchlist {

//     @JsonProperty
    private static final Map<String, Integer> stockNameIncrement = new HashMap<>();
//     private UUID uuid;

    public static Map<String, Integer> getStocknameincrement() {
        return stockNameIncrement;
    }

//     public Watchlist() {
//     }

//      @Autowired
//     public Watchlist(UUID uuid) {
//         if(uuid == null){
//             this.uuid = generateUUID("default");
//         }else{
//             this.uuid = uuid;
//         }
//     }

//     public UUID generateUUID(String stockName){
//         int stockNameCount = stockNameIncrement.getOrDefault(stockName, 0);
//         stockNameIncrement.put(stockName, stockNameCount + 1);
//         return UUID.nameUUIDFromBytes((stockName + stockNameCount).getBytes());
//     }

//    public UUID getUuid() {
//         return uuid;
//     } 

//     @Override
//     public String toString() {
//         return "ImmutableWatchlist [uuid=" + uuid + "]";
//     }
}
