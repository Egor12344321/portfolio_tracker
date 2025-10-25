package com.example.portfolio_tracker.controller;


import com.example.portfolio_tracker.dto.PortfolioStats;
import com.example.portfolio_tracker.models.Portfolio;
import com.example.portfolio_tracker.models.PortfolioItem;
import com.example.portfolio_tracker.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<List<Portfolio>> getAllPortfolios(){
        return ResponseEntity.ok(portfolioService.getAllPortfolios());
    }

    @PostMapping
    public Portfolio createPortfolio(@RequestParam String name){
        return portfolioService.createPortfolio(name);
    }

    @GetMapping("/{portfolioId}/items")
    public List<PortfolioItem> getPortfolioItems(@PathVariable Long portfolioId){
        return portfolioService.getPortfolioItems(portfolioId);
    }

    @PostMapping("/{portfolioId}/buy")
        public ResponseEntity<?> buyStock(@PathVariable Long portfolioId, @RequestParam String stockTicker, @RequestParam Integer count, @RequestParam Double price){
        PortfolioItem item = portfolioService.buyStock(portfolioId, stockTicker, count, price);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{portfolioId}/stats")
    public PortfolioStats getPortfolioStats(@PathVariable Long portfolioId){
        return portfolioService.calculatePortfolioStats(portfolioId);
    }
}
