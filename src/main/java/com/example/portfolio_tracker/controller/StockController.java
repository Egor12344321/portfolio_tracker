package com.example.portfolio_tracker.controller;


import com.example.portfolio_tracker.models.Stock;
import com.example.portfolio_tracker.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    StockService stockService;

    @PostMapping
    public Stock createStock(@RequestBody Stock stock){
        return stockService.createStock(stock.getTicker(), stock.getName(), stock.getCurrentPrice());
    }

    @GetMapping
    public List<Stock> getAllStocks(){
        return stockService.getAllStocks();
    }

}
