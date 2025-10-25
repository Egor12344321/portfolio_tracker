package com.example.portfolio_tracker.service;

import com.example.portfolio_tracker.dto.PortfolioUpdate;
import com.example.portfolio_tracker.dto.StockPriceUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;



@Service
public class WebSocketService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(WebSocketService.class);

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    public void sendStockPriceUpdate(String ticker, Double price){

        try{
            StockPriceUpdate update = new StockPriceUpdate(ticker, price);
            simpMessagingTemplate.convertAndSend("/topic/stock-prices", update);
            logger.info("Отправлен stock price update: {} = ${}", ticker, price);
        } catch (Exception e){
            logger.error("Ошибка отправки stock price update {}", ticker);
        }
    }

    public void sendPortfolioUpdate(PortfolioUpdate portfolioUpdate){
        try{
            simpMessagingTemplate.convertAndSend("/topic/portfolio-updates", portfolioUpdate);
            logger.info("Отправлен portfolio update: {}", portfolioUpdate.getPortfolioName());
        } catch (Exception e) {
            logger.error("Ошибка отправки portfolio update: {}", e.getMessage());
        }
    }

    public void sendNotifications(String message) {
        try {
            simpMessagingTemplate.convertAndSend("/topic/notifications", message);
            logger.info("Отправлено оповещение: {}", message);
        } catch (Exception e) {
            logger.error("Ошибка отправки оповещения: {}", e.getMessage());
        }
    }
}
