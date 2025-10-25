package com.example.portfolio_tracker.exceptions;

public abstract class BusinessException extends RuntimeException{
    private final String errorCode;

    public BusinessException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return errorCode;
    }
}
