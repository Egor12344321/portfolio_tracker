package com.example.portfolio_tracker.exceptions;

public class StockNotFoundException extends BusinessException{
    public StockNotFoundException(String message) {
        super("STOCK_NOT_FOUND", message);
    }


}
