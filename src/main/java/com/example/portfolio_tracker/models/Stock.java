package com.example.portfolio_tracker.models;


import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticker")
    private String ticker;

    @Column
    private String name;

    @Column(name = "current_price")
    private Double currentPrice;

    public Stock(){}

    public Stock(String ticker, String name, Double currentPrice) {
        this.ticker = ticker;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
