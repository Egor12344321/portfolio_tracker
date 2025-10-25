package com.example.portfolio_tracker.service;

import com.example.portfolio_tracker.exceptions.StockNotFoundException;
import com.example.portfolio_tracker.models.Stock;
import com.example.portfolio_tracker.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    private WebSocketService webSocketService;

    @Autowired
    private PortfolioService portfolioService;

    public Stock getStockByTicker(String ticker){
        return stockRepository.findByTicker(ticker)
                .orElseThrow(() -> new StockNotFoundException("Сток с таким тикером не найден"));
    }

    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    public Stock createStock(String ticker, String name, Double currentPrice){
        Stock stock = new Stock(ticker, name, currentPrice);
        return stockRepository.save(stock);

    }



    public void updateStockPrice(String ticker, Double price){
        System.out.println("Я в апдейте стокпрайса");
        Stock stock = getStockByTicker(ticker);

        if (stock != null){
            stock.setCurrentPrice(price);
            stockRepository.save(stock);
            webSocketService.sendStockPriceUpdate(ticker, price);

            }
    }

}
