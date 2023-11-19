    package com.cbfacademy.apiassessment.model;

    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.util.UUID;

    import org.json.simple.JSONObject;
    import org.springframework.stereotype.Component;

    import com.fasterxml.jackson.annotation.JsonFormat;

    // model that shows the structure for the watchlist
    /**
     * Constructs a Watchlist entry with the provided parameters.
     * Generates a UUID if the given UUID parameter is null.
     *
     * @param uuid           The UUID of the entry (can be null).
     * @param stockName      The name of the stock.
     * @param symbol         The symbol representing the stock.
     * @param currency       The currency used for the stock.
     * @param datePurchased  The date when the stock was purchased.
     * @param ownsVolStock   The volume of stock owned.
     * @param wantsVolStock  The volume of stock wanted.
     * @param purchasePrice  The price at which the stock was purchased.
     * @param currentPrice   The current price of the stock.
     * @param profit         The profit generated from the stock.
     * @param pointsChange   The change in points for the stock.
     * @param open           The opening price of the stock.
     * @param close          The closing price of the stock.
     * @param intradayHigh   The intraday high of the stock.
     */
    public Watchlist(UUID uuid, String stockName, String symbol, String currency, LocalDate datePurchased,
                    Integer ownsVolStock, Integer wantsVolStock, double purchasePrice, double currentPrice,
                    double profit, double pointsChange, double open, double close, double intradayHigh) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.stockName = stockName;
        this.symbol = symbol;
        this.currency = currency;
        this.datePurchased = datePurchased;
        this.ownsVolStock = ownsVolStock;
        this.wantsVolStock = wantsVolStock;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
        this.profit = profit;
        this.pointsChange = pointsChange;
        this.open = open;
        this.close = close;
        this.intradayHigh = intradayHigh;
    }

    /**
     * Constructs an empty Watchlist entry.
     */
    public Watchlist() {
        // Empty constructor
    }

        // generating uuid with this constructor and implementing the logic so that it is generated if uuid is null
        public Watchlist(UUID uuid, String stockName, String symbol, String currency, LocalDate datePurchased, Integer ownsVolStock, Integer wantsVolStock, double purchasePrice, double currentPrice, double profit, double pointsChange, double open, double close, double intradayHigh) {
            this.uuid = uuid == null ? UUID.randomUUID() : uuid;
            this.stockName = stockName;
            this.symbol = symbol;
            this.currency = currency;
            this.datePurchased = datePurchased;
            this.ownsVolStock = ownsVolStock;
            this.wantsVolStock = wantsVolStock;
            this.purchasePrice = purchasePrice;
            this.currentPrice = currentPrice;
            this.profit = profit;
            this.pointsChange = pointsChange;
            this.open = open;
            this.close = close;
            this.intradayHigh = intradayHigh;
        }
    /**
     * Constructs a Watchlist entry by parsing data from a JSONObject.
     *
     * @param json The JSONObject containing data to construct the Watchlist entry.
     */
    public Watchlist(JSONObject json) {
        Object uuidObj = json.get("uuid");
        if (uuidObj instanceof String) {
            this.uuid = UUID.fromString((String) uuidObj);
        } else {
            this.uuid = UUID.randomUUID();
        }
        this.stockName = (String) json.get("stockName");
        this.symbol = (String) json.get("symbol");
        this.currency = (String) json.get("currency");
        String datePurchasedStr = (String) json.get("datePurchased");
        this.datePurchased = LocalDate.parse(datePurchasedStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.ownsVolStock = (Integer) json.get("ownsVolStock");
        this.wantsVolStock = (Integer) json.get("wantsVolStock");
        this.profit = (double) json.get("profit");
        this.pointsChange = (double) json.get("pointsChange");
        this.open = (double) json.get("open");
        this.close = (double) json.get("close");
        this.intradayHigh = (double) json.get("intradayHigh");
    }       

    /**
     * Constructs a Watchlist entry with specified parameters.
     *
     * @param currency       The currency of the stock.
     * @param datePurchased  The date when the stock was purchased.
     * @param ownsVolStock   The volume of stock owned.
     * @param wantsVolStock  The volume of stock desired.
     * @param purchasePrice  The price at which the stock was purchased.
     * @param currentPrice   The current price of the stock.
     * @param profit         The profit calculated based on the stock transaction.
     * @param pointsChange   The change in points based on open and close prices.
     * @param open           The opening price of the stock.
     * @param close          The closing price of the stock.
     * @param intradayHigh   The highest price of the stock during a trading day.
     */
    public Watchlist(String currency, LocalDate datePurchased, Integer ownsVolStock, Integer wantsVolStock,
                    double purchasePrice, double currentPrice, double profit, double pointsChange,
                    double open, double close, double intradayHigh) {
        this.currency = currency;
        this.datePurchased = datePurchased;
        this.ownsVolStock = ownsVolStock;
        this.wantsVolStock = wantsVolStock;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
        this.profit = profit;
        this.pointsChange = pointsChange;
        this.open = open;
        this.close = close;
        this.intradayHigh = intradayHigh;
    }
    
            /** 
             * @return UUID
             */
        /**
         * Retrieves the UUID of the watchlist entry.
         * @return The UUID of the watchlist entry.
         */
        public UUID getUuid() {
            return uuid;
        }

        /**
         * Sets the UUID of the watchlist entry.
         * @param uuid The UUID to set.
         */
        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * Retrieves the stock name.
         * @return The stock name.
         */
        public String getStockName() {
            return stockName;
        }

        /**
         * Sets the stock name.
         * @param stockName The stock name to set.
         */
        public void setStockName(String stockName) {
            this.stockName = stockName;
        }

        /**
         * Retrieves the symbol.
         * @return The symbol.
         */
        public String getSymbol() {
            return symbol;
        }

        /**
         * Sets the symbol.
         * @param symbol The symbol to set.
         */
        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        /**
         * Retrieves the currency.
         * @return The currency.
         */
        public String getCurrency() {
            return currency;
        }

        /**
         * Sets the currency.
         * @param currency The currency to set.
         */
        public void setCurrency(String currency) {
            this.currency = currency;
        }

        /**
         * Retrieves the date of purchase.
         * @return The date of purchase.
         */
        public LocalDate getDatePurchased() {
            return datePurchased;
        }
        /**
         * Sets the date of purchase.
         * @param datePurchased The date of purchase to set.
         */
        public void setDatePurchased(LocalDate datePurchased) {
            this.datePurchased = datePurchased;
        }

        /**
         * Gets the number of stocks owned.
         * @return The number of stocks owned.
         */
        public Integer getOwnsVolStock() {
            return ownsVolStock;
        }

        /**
         * Sets the number of stocks owned and recalculates the profit.
         * @param has The number of stocks owned to set.
         */
        public void setOwnsVolStock(Integer has) {
            this.ownsVolStock = has;
            calculateProfit();
        }

        /**
         * Gets the number of stocks wanted.
         * @return The number of stocks wanted.
         */
        public Integer getWantsVolStock() {
            return wantsVolStock;
        }

        /**
         * Sets the number of stocks wanted.
         * @param wants The number of stocks wanted to set.
         */
        public void setWantsVolStock(Integer wants) {
            this.wantsVolStock = wants;
        }

        /**
         * Gets the purchase price.
         * @return The purchase price.
         */
        public double getPurchasePrice() {
            return purchasePrice;
        }

        /**
         * Sets the purchase price and recalculates the profit.
         * @param purchasePrice The purchase price to set.
         */
        public void setPurchasePrice(double purchasePrice) {
            this.purchasePrice = purchasePrice;
            calculateProfit();
        }

        /**
         * Gets the current price.
         * @return The current price.
         */
        public double getCurrentPrice() {
            return currentPrice;
        }

        /**
         * Sets the current price and recalculates the profit.
         * @param currentPrice The current price to set.
         */
        public void setCurrentPrice(double currentPrice) {
            this.currentPrice = currentPrice;
            calculateProfit();
        }

        /**
         * Gets the profit.
         * @return The profit.
         */
        public double getProfit() {
            return profit;
        }

        /**
         * Sets the profit based on the current and purchase prices.
         * @param profit The profit to set.
         */
        public void setProfit(double profit) {
            this.profit = (getOwnsVolStock() * getCurrentPrice()) - (getOwnsVolStock() * getPurchasePrice());
        }

        /**
         * Calculates the profit based on the current and purchase prices and the number of owned stocks.
         * This method is called whenever the owned stocks, purchase price, or current price is updated.
         */
        private void calculateProfit() {
            this.pointsChange = this.ownsVolStock * this.currentPrice - this.ownsVolStock * this.purchasePrice; 
        }
        /**
         * Gets the points change value.
         * @return The points change value.
         */
        public double getPointsChange() {
            return pointsChange;
        }

        /**
         * Sets the points change value automatically based on the difference between close and open prices.
         * @param pointsChange The points change value to set.
         */
        public void setPointsChange(double pointsChange) {
            this.pointsChange = getClose() - getOpen();
        }

        /**
         * Gets the open price.
         * @return The open price.
         */
        public double getOpen() {
            return open;
        }

        /**
         * Sets the open price and recalculates the points change accordingly.
         * @param open The open price to set.
         */
        public void setOpen(double open) {
            this.open = open;
            calculatePointsChange();
        }

        /**
         * Gets the close price.
         * @return The close price.
         */
        public double getClose() {
            return close;
        }

        /**
         * Sets the close price and recalculates the points change accordingly.
         * @param close The close price to set.
         */
        public void setClose(double close) {
            this.close = close;
            calculatePointsChange();
        }

        /**
         * Calculates the points change based on the difference between close and open prices.
         * This method is called whenever open or close prices are updated.
         */
        private void calculatePointsChange() {
            this.pointsChange = this.close - this.open; 
        }
        /**
         * Gets the intraday high value.
         * @return The intraday high value.
         */
        public double getIntradayHigh() {
            return intradayHigh;
        }

        /**
         * Sets the intraday high value.
         * @param intradayHigh The intraday high value to set.
         */
            public void setIntradayHigh(double intradayHigh) {
                this.intradayHigh = intradayHigh;
            }

        /**
         * Generates a string representation of the Watchlist object.
         * @return A string representing the Watchlist object's attributes.
         */
        @Override
            public String toString() {
                return "Watchlist [uuid=" + uuid + ", stockName=" + stockName + ", symbol=" + symbol + "currency=" + currency + ", datePurchased=" + datePurchased + ", has=" + ownsVolStock + ", wants=" + wantsVolStock + ", profit=" + profit + ", pointsChange=" + pointsChange + ", open=" + open + ", close=" + close + ", intradayHigh=" + intradayHigh + "]";
            }
}