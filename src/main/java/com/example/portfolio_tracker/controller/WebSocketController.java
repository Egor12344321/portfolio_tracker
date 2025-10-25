package com.example.portfolio_tracker.controller;


import com.example.portfolio_tracker.service.PortfolioService;
import com.example.portfolio_tracker.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {


    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private StockService stockService;

    @MessageMapping("/portfolio.subscribe")
    public void handlePortfolioSubscribe(Long portfolioId){
        System.out.println("Пользователь " + portfolioId + " подписался на обновления");
    }

    @MessageMapping("/portfolio.unsubscribe")
    public void unsubscribeFromPortfolio(Long portfolioId){
        System.out.println("Пользователь отписался от обновлений портфеля " + portfolioId);
    }

    @MessageMapping("/request.portfolio.update")
    @SendTo("/topic/portfolio.updates")
    public Object requestPortfolioUpdate(Long portfolioId) {
        System.out.println("Received portfolio update request for ID: " + portfolioId);
        return portfolioService.calculatePortfolioStats(portfolioId);
    }

    @MessageMapping("/request.stock.price")
    @SendTo("/topic/stock.prices")
    public Object requestStockPrice(String ticker) {
        System.out.println("Received stock price request for: " + ticker);
        return stockService.getStockByTicker(ticker);
    }

}
