package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;
import javax.persistence.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class Watchlist {

    // handle inheritance

    @Id
    private Long id;
    private String stockName;
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

    public Watchlist(Long id, String stockName, String symbol, boolean owned, String status, String currency,
            LocalDate datePurchased, Integer unitsOwned, double profit, double pointsChange, double open, double close,
            double intradayHigh) {
        this.id = id;
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
    
    /** 
     * @return Long
     */
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return this.pointsChange;
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

    public double getIntradayHigh() {
        return intradayHigh;
    }

    public void setIntradayHigh(double high) {
        this.intradayHigh = high;
    }

    public Watchlist() {
    }
    
       @Override
    public String toString() {
        return "DatabaseModel [id=" + id + ", StockName=" + stockName + ", Symbol=" + symbol + ", owned=" + owned
                + ", status=" + status + ", Currency=" + currency + ", datePurchased=" + datePurchased + ", unitsOwned="
                + unitsOwned + ", pointsChange=" + pointsChange + ", profit=" + profit + ", open=" + open + ", close="
                + close + ", high=" + intradayHigh + "]";
    }

    public Watchlist upWatchlist(Watchlist watchlist){
        return new Watchlist(
            watchlist.id, //this.id, may need to add id to the constructor also
            watchlist.stockName,
            watchlist.symbol,
            watchlist.owned,
            watchlist.status,
            watchlist.currency,
            watchlist.datePurchased,
            watchlist.unitsOwned,
            watchlist.pointsChange,
            watchlist.profit,
            watchlist.open,
            watchlist.close,
            watchlist.intradayHigh
        );
        
    }

}
