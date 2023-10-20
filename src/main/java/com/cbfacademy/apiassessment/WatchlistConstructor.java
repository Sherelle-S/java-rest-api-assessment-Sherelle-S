package com.cbfacademy.apiassessment;

import java.time.LocalDate;

public class WatchlistConstructor {
    private long id;
    private String StockName;
    private String Symbol;
    private boolean owned;
    private String status;
    private String Currency;
    private LocalDate datePurchased;
    private Integer unitsOwned;
    private double pointsChange;
    private double profit;
    private double open;
    private double close;
    private double high;

    // public WatchlistConstructor() {
    // }

    //     public WatchlistConstructor(String stockName, String symbol, boolean owned, String status, String currency,
    //         LocalDate datePurchased, Integer unitsOwned, double pointsChange, double profit, double open,
    //         double close, double high) {
    //     StockName = stockName;
    //     Symbol = symbol;
    //     this.owned = owned;
    //     this.status = status;
    //     Currency = currency;
    //     this.datePurchased = datePurchased;
    //     this.unitsOwned = unitsOwned;
    //     this.pointsChange = pointsChange;
    //     this.profit = profit;
    //     this.open = open;
    //     this.close = close;
    //     this.high = high;
    // }

    public WatchlistConstructor(long id, String stockName, String symbol, boolean owned, String status, String currency,
            LocalDate datePurchased, Integer unitsOwned, double pointsChange, double d, double open,
            double close, double high) {
        this.id = id;
        StockName = stockName;
        Symbol = symbol;
        this.owned = owned;
        this.status = status;
        Currency = currency;
        this.datePurchased = datePurchased;
        this.unitsOwned = unitsOwned;
        this.pointsChange = pointsChange;
        this.profit = d;
        this.open = open;
        this.close = close;
        this.high = high;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStockName() {
        return StockName;
    }
    public void setStockName(String stockName) {
        StockName = stockName;
    }
    public String getSymbol() {
        return Symbol;
    }
    public void setSymbol(String symbol) {
        Symbol = symbol;
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
        return Currency;
    }
    public void setCurrency(String currency) {
        Currency = currency;
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
    public double getPointsChange() {
        return pointsChange;
    }
    public void setPointsChange(double pointsChange) {
        this.pointsChange = pointsChange;
    }
    public double getProfit() {
        return profit;
    }
    public void setProfit(double profit) {
        this.profit = profit;
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
    public double getHigh() {
        return high;
    }
    public void setHigh(double high) {
        this.high = high;
    }

        @Override
    public String toString() {
        return "WatchlistConstructor [id=" + id + ", StockName=" + StockName + ", Symbol=" + Symbol + ", owned=" + owned
                + ", status=" + status + ", Currency=" + Currency + ", datePurchased=" + datePurchased + ", unitsOwned="
                + unitsOwned + ", pointsChange=" + pointsChange + ", profit=" + profit + ", open=" + open + ", close="
                + close + ", high=" + high + "]";
    }

}
