package com.example.portfolio_tracker.dto;

public class PortfolioItemUpdate {
    private String ticker;
    private String stockName;
    private Integer count;
    private Double currentPrice;
    private Double totalValue;

    public PortfolioItemUpdate() {}

    public PortfolioItemUpdate(String ticker, String stockName, Integer count, Double currentPrice) {
        this.ticker = ticker;
        this.stockName = stockName;
        this.count = count;
        this.currentPrice = currentPrice;
        this.totalValue = count * currentPrice;
    }


    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public String getTicker() {
        return ticker;
    }

    public String getStockName() {
        return stockName;
    }

    public Integer getCount() {
        return count;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Double getTotalValue() {
        return totalValue;
    }
}
