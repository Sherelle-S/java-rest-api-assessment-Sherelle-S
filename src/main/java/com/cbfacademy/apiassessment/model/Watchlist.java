package com.cbfacademy.apiassessment.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Watchlist {

    private UUID uuid;
    private String stockName;
    private String symbol;

    public Watchlist() {
    }

    public Watchlist(UUID uuid, String stockName, String symbol) {
        if(uuid == null){
        this.uuid = UUID.randomUUID();
        }else{
            this.uuid = uuid;
        }
        this.stockName = stockName;
        this.symbol = symbol;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Watchlist [uuid=" + uuid + ", stockName=" + stockName + ", symbol=" + symbol + "]";
    }
}
//     @JsonProperty
//     private static final Map<String, Integer> stockNameIncrement = new HashMap<>();
// //     private UUID uuid;

//     public static Map<String, Integer> getStocknameincrement() {
//         return stockNameIncrement;
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
// }
