package com.cbfacademy.apiassessment;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WatchList {

    @Id
    private ObjectId id;
    private String stockName;
    private String symbol;
    private boolean owned;
    private String status;
    private String currency;
    private LocalDate datePurchased;
    private Integer unitsOwned;
    private double pointsChange;
    private double profit;
    private double open;
    private double close;
    private double high;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public double getPointsChange() {
        return this.close - this.open;
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

    public WatchList() {
    }
    
     public WatchList(String stockName, String symbol, boolean owned, String status, String currency,
            LocalDate datePurchased, Integer unitsOwned, double pointsChange, double profit, double open, double close,
            double high) {
        this.stockName = stockName;
        this.symbol = symbol;
        this.owned = owned;
        this.status = status;
        this.currency = currency;
        this.datePurchased = datePurchased;
        this.unitsOwned = unitsOwned;
        this.pointsChange = pointsChange;
        this.profit = profit;
        this.open = open;
        this.close = close;
        this.high = high;
    }

       @Override
    public String toString() {
        return "DatabaseModel [id=" + id + ", StockName=" + stockName + ", Symbol=" + symbol + ", owned=" + owned
                + ", status=" + status + ", Currency=" + currency + ", datePurchased=" + datePurchased + ", unitsOwned="
                + unitsOwned + ", pointsChange=" + pointsChange + ", profit=" + profit + ", open=" + open + ", close="
                + close + ", high=" + high + "]";
    }

}
