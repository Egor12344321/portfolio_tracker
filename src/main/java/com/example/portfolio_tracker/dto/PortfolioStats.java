package com.example.portfolio_tracker.dto;

public class PortfolioStats {
    private Double totalInvestment;
    private Double totalCurrentValue;
    private Double totalProfitLoss;
    private Double totalProfitLossPercentage;

    public PortfolioStats(Double totalInvestment, Double totalCurrentValue, Double totalProfitLoss, Double totalProfitLossPercentage) {
        this.totalInvestment = totalInvestment;
        this.totalCurrentValue = totalCurrentValue;
        this.totalProfitLoss = totalProfitLoss;
        this.totalProfitLossPercentage = totalProfitLossPercentage;
    }

    public Double getTotalInvestment() {
        return totalInvestment;
    }

    public Double getTotalCurrentValue() {
        return totalCurrentValue;
    }

    public Double getTotalProfitLoss() {
        return totalProfitLoss;
    }

    public Double getTotalProfitLossPercentage() {
        return totalProfitLossPercentage;
    }

    public void setTotalInvestment(Double totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public void setTotalCurrentValue(Double totalCurrentValue) {
        this.totalCurrentValue = totalCurrentValue;
    }

    public void setTotalProfitLoss(Double totalProfitLoss) {
        this.totalProfitLoss = totalProfitLoss;
    }

    public void setTotalProfitLossPercentage(Double totalProfitLossPercentage) {
        this.totalProfitLossPercentage = totalProfitLossPercentage;
    }
}
