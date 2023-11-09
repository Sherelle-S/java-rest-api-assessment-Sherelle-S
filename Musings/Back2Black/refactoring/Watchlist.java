package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonValue;

// @Configuration REMOVED
// the database model that lets the watchlist know what it should have
// see about making this inheritable
public class Watchlist {
    
    private static final Map<String, Integer> stockNameIncrement = new HashMap<>();
    private final UUID id;
    private final String stockName;
    private String symbol;
    private boolean owned;
    private String status;
    private String currency;
    private LocalDate datePurchased;
    private Integer unitsOwned;
    private double profit;
    private double pointsChange;
    private double open;
    private double close;
    private double intradayHigh;

    // constructor for the initial input 
    public Watchlist(String stockName, String symbol, boolean owned, String status, String currency,
        LocalDate datePurchased, Integer unitsOwned, double profit, double pointsChange, double open, double close,
        double intradayHigh) {
            super();
        this.id = generateUUID(stockName);
        this.stockName = stockName;
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

    // blank constructor is initialized with the values that are final and should not be changed once set
     public Watchlist() {
        this.stockName = "default";
        this.id = generateUUID("default");
    }


    // generates a unique ID for each item as DB's usually create their own, we must find a way to make one
    public UUID generateUUID(String stockName){
        int stockNameCount = stockNameIncrement.getOrDefault(stockName, 0);
        stockNameIncrement.put(stockName, stockNameCount + 1);
        return UUID.nameUUIDFromBytes((stockName + stockNameCount).getBytes());
    }

   public UUID getUuid() {
        return id;
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
        this.pointsChange = pointsChange;
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
    @JsonValue
    public String toString() {
        return "Watchlist [id=" + id + ", stockName=" + stockName + ", symbol=" + symbol + ", owned=" + owned
                + ", status=" + status + ", currency=" + currency + ", datePurchased=" + datePurchased + ", unitsOwned="
                + unitsOwned + ", profit=" + profit + ", pointsChange=" + pointsChange + ", open=" + open + ", close="
                + close + ", intradayHigh=" + intradayHigh + "]";
    }
}
