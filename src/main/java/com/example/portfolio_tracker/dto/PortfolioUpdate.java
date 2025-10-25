package com.example.portfolio_tracker.dto;

import com.example.portfolio_tracker.models.PortfolioItem;

import java.util.List;

public class PortfolioUpdate {
    private Long portfolioId;
    private String portfolioName;
    private Double totalValue;
    private Double dailyChange;
    private Double dailyChangePercent;
    private List<PortfolioItem> items;

    public PortfolioUpdate() {}

    public PortfolioUpdate(Long portfolioId, String portfolioName, Double totalValue) {
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
        this.totalValue = totalValue;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public void setDailyChange(Double dailyChange) {
        this.dailyChange = dailyChange;
    }

    public void setDailyChangePercent(Double dailyChangePercent) {
        this.dailyChangePercent = dailyChangePercent;
    }

    public void setItems(List<PortfolioItem> items) {
        this.items = items;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Double getDailyChange() {
        return dailyChange;
    }

    public Double getDailyChangePercent() {
        return dailyChangePercent;
    }

    public List<PortfolioItem> getItems() {
        return items;
    }
}
