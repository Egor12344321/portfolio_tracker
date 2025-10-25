package com.example.portfolio_tracker.dto;

import java.time.LocalDateTime;

public class StockPriceUpdate {
    private String ticker;
    private Double price;
    private Double change;
    private Double changePercent;
    private LocalDateTime timestamp;


    public StockPriceUpdate(String ticker, Double price) {
        this.ticker = ticker;
        this.price = price;
        this.timestamp = LocalDateTime.now();
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public void setChangePercent(Double changePercent) {
        this.changePercent = changePercent;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTicker() {
        return ticker;
    }

    public Double getPrice() {
        return price;
    }

    public Double getChange() {
        return change;
    }

    public Double getChangePercent() {
        return changePercent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
