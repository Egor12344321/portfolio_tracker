package com.example.portfolio_tracker.exceptions;

public class PortfolioNotFoundException extends BusinessException{
    public PortfolioNotFoundException(String message){
        super("PORTFOLIO_NOT_FOUND", message);
    }

    public PortfolioNotFoundException(Long portfolioId) {
        super("PORTFOLIO_NOT_FOUND", "Portfolio with id " + portfolioId + " not found");
    }
}
