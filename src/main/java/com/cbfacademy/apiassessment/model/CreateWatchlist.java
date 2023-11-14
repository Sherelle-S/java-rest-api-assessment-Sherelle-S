package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

// inherits from watchlist and creates a new watchlist constructor
@Component
public class CreateWatchlist extends Watchlist{

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

    // empty constructor for spring boot
     public CreateWatchlist(Object object, String string, String string2, boolean b, String string3, String string4, LocalDate localDate, int i, double d, double e, double f, double g, double h) {
    }
        //  @Autowired
        public CreateWatchlist(String currency, LocalDate datePurchased, Integer has, Integer wants, double profit, double pointsChange, double open, double close, double intradayHigh) {
        super();
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

    // constructor with elements inherited from watchlist
    public CreateWatchlist(UUID ud, String stockName, String symbol, String currency, LocalDate datePurchased, Integer has, Integer wants, double profit, double pointsChange, double open, double close, double intradayHigh) {
    super();
    }

    // constructor for createWatchlist object that takes in JSONObject as a parameter to to facilitate retrieval and conversion of json
    public CreateWatchlist(JSONObject json){
        super((UUID) json.get("uuid"), (String) json.get("stockName"), (String) json.get("symbol"));
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
        return "WatchlistInherited [currency=" + currency + ", datePurchased=" + datePurchased + ", has=" + has + ", wants=" + wants + ", profit=" + profit + ", pointsChange=" + pointsChange + ", open=" + open + ", close=" + close + ", intradayHigh=" + intradayHigh + "]";
    }

}
