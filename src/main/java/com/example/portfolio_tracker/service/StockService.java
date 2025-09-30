package com.example.portfolio_tracker.service;

import com.example.portfolio_tracker.models.Stock;
import com.example.portfolio_tracker.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    public Stock createStock(String ticker, String name, Double currentPrice){
        Stock stock = new Stock(ticker, name, currentPrice);
        return stockRepository.save(stock);

    }

    public Stock getStockByTicker(String ticker){
        if (stockRepository.findByTicker(ticker).isPresent()) {
            return stockRepository.findByTicker(ticker).get();
        } else {
            return null;
        }
    }


}
