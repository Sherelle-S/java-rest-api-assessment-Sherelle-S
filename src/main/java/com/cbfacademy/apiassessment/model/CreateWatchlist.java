package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

// inherits from watchlist and creates a new watchlist constructor
@Component
public class CreateWatchlist extends Watchlist{

    private UUID uuid;
    private String stockName;
    private String symbol;
    private boolean owned;
    private String status;
    private String currency;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datePurchased;
    private Integer unitsOwned;
    private double profit;
    private double pointsChange;
    private double open;
    private double close;
    private double intradayHigh;

    public CreateWatchlist() {
    super();
    }

        //  @Autowired
        public CreateWatchlist(UUID uuid, String stockName, String symbol, boolean owned, String status, String currency,
            LocalDate datePurchased, Integer unitsOwned, double profit, double pointsChange, double open, double close,
            double intradayHigh) {
        super();
            
        if(uuid == null){
            this.uuid = generateUUID(stockName);
        }else{
            this.uuid = uuid;
        }
        this.symbol = symbol;
        this.owned = owned;
        this.status = status;
        this.currency = currency;
        this.datePurchased = datePurchased;
        this.unitsOwned = unitsOwned;
        this.profit = profit;
        this.pointsChange = pointsChange;
        this.open = open;
        this.close = close;
        this.intradayHigh = intradayHigh;
    }

    //  public CreateWatchlist() {
    // }

        public UUID generateUUID(String stockName){
        int stockNameCount = getStocknameincrement().getOrDefault(stockName, 0);
        getStocknameincrement().put(stockName, stockNameCount + 1);
        return UUID.nameUUIDFromBytes((stockName + stockNameCount).getBytes());
    }

       public UUID getUuid() {
        return uuid;
    } 

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public String getStockName() {
        return stockName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(LocalDate datePurchased) {
        this.datePurchased = datePurchased;
    }

    public Integer getUnitsOwned() {
        return unitsOwned;
    }

    public void setUnitsOwned(Integer unitsOwned) {
        this.unitsOwned = unitsOwned;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getPointsChange() {
        return pointsChange;
    }

    public void setPointsChange(double pointsChange) {
        this.pointsChange = getClose() - getOpen();
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getIntradayHigh() {
        return intradayHigh;
    }

    public void setIntradayHigh(double intradayHigh) {
        this.intradayHigh = intradayHigh;
    }

        @Override
    public String toString() {
        return "WatchlistInherited [symbol=" + symbol + ", owned=" + owned + ", status=" + status + ", currency="
        + currency + ", datePurchased=" + datePurchased + ", unitsOwned=" + unitsOwned + ", profit=" + profit
        + ", pointsChange=" + pointsChange + ", open=" + open + ", close=" + close + ", intradayHigh="
        + intradayHigh + "]";
    }

}
