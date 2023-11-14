package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Watchlist {

    private UUID uuid;
    private String stockName;
    private String symbol;
     private String currency;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datePurchased;
    private Integer wants;
    private Integer has;
    private double profit;
    private double pointsChange;
    private double open;
    private double close;
    private double intradayHigh;

    public Watchlist() {
    }

    public Watchlist(UUID uuid, String stockName, String symbol, String currency, LocalDate datePurchased, Integer has, Integer wants, double profit, double pointsChange, double open, double close, double intradayHigh) {
        this.uuid = UUID.randomUUID();
        this.stockName = stockName;
        this.symbol = symbol;
        this.currency = currency;
        this.datePurchased = datePurchased;
        this.has = has;
        this.wants = wants;
        this.profit = profit;
        this.pointsChange = pointsChange;
        this.open = open;
        this.close = close;
        this.intradayHigh = intradayHigh;
    }

        public Watchlist(JSONObject json){
        this.uuid = (UUID) json.get("uuid");
        this.stockName = (String) json.get("stockName");
        this.symbol = (String) json.get("symbol");
        this.currency = (String) json.get("currency");
        String datePurchasedStr = (String) json.get("datePurchased");
        this.datePurchased = LocalDate.parse(datePurchasedStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.has = (Integer) json.get("has");
        this.wants = (Integer) json.get("wants");
        this.profit = (double) json.get("profit");
        this.pointsChange = (double) json.get("pointsChange");
        this.open = (double) json.get("open");
        this.close = (double) json.get("close");
        this.intradayHigh = (double) json.get("intradayHigh");
    }

        public Watchlist(String currency, LocalDate datePurchased, Integer has, Integer wants, double profit, double pointsChange, double open, double close, double intradayHigh) {
        this.currency = currency;
        this.datePurchased = datePurchased;
        this.has = has;
        this.wants = wants;
        this.profit = profit;
        this.pointsChange = pointsChange;
        this.open = open;
        this.close = close;
        this.intradayHigh = intradayHigh;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
        // generateUUID();
    }

    // public void generateUUID(){
    //     if (uuid == null){
    //         this.uuid 
    //     } else{
    //         this.uuid = uuid;
    //     }
    // }

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

    public Integer getHas() {
        return has;
    }

    public void setHas(Integer has) {
        this.has = has;
    }

    public Integer getWants() {
        return wants;
    }

    public void setWants(Integer wants) {
        this.wants = wants;
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
        calculatePointsChange();
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
        calculatePointsChange();
    }

    private void calculatePointsChange() {
        this.pointsChange = this.close - this.open; 
    }

    public double getIntradayHigh() {
        return intradayHigh;
    }

    public void setIntradayHigh(double intradayHigh) {
        this.intradayHigh = intradayHigh;
    }

    @Override
    public String toString() {
        return "Watchlist [uuid=" + uuid + ", stockName=" + stockName + ", symbol=" + symbol + "currency=" + currency + ", datePurchased=" + datePurchased + ", has=" + has + ", wants=" + wants + ", profit=" + profit + ", pointsChange=" + pointsChange + ", open=" + open + ", close=" + close + ", intradayHigh=" + intradayHigh + "]";
    }
}