package com.example.portfolio_tracker.controller;

import com.example.portfolio_tracker.models.Stock;
import com.example.portfolio_tracker.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private StockService stockService;

    // ✅ ДОБАВЬ ЭТОТ МЕТОД!
    @PostMapping("/update-stock-price")
    public String updateStockPrice(@RequestParam String ticker, @RequestParam Double price) {
        System.out.println("=== 1. TestController: received request ===");
        System.out.println("Ticker: " + ticker + ", Price: " + price);

        stockService.updateStockPrice(ticker, price);

        System.out.println("=== 1. TestController: finished ===");
        return "Цена акции " + ticker + " обновлена на $" + price;
    }
    @PostMapping("/create-test-stock")
    public String createTestStock(@RequestParam String ticker, @RequestParam String name, @RequestParam Double price) {
        System.out.println("Creating test stock: " + ticker);
        Stock stock = stockService.createStock(ticker, name, price);
        return "Акция " + ticker + " создана с ценой $" + price;
    }
    // ✅ ДОБАВЬ И ЭТОТ ДЛЯ ПРОВЕРКИ
    @GetMapping("/hello")
    public String hello() {
        return "Test controller is working!";
    }
}