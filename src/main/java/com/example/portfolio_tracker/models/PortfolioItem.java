package com.example.portfolio_tracker.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "portfolio_item")
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Column(name = "count")
    private Integer count;

    @Column(name = "price")
    private Double purchasePrice;

    @Column(name = "date")
    private LocalDateTime purchaseDate;

    public PortfolioItem(){}

    public PortfolioItem(Portfolio portfolio, Stock stock, Integer count, Double purchasePrice) {
        this.portfolio = portfolio;
        this.stock = stock;
        this.count = count;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = LocalDateTime.now();
    }

    public Long getId() {
        return Id;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public Stock getStock() {
        return stock;
    }

    public Integer getCount() {
        return count;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
