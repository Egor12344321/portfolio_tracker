package com.example.portfolio_tracker.service;

import com.example.portfolio_tracker.dto.PortfolioStats;
import com.example.portfolio_tracker.exceptions.PortfolioNotFoundException;
import com.example.portfolio_tracker.exceptions.StockNotFoundException;
import com.example.portfolio_tracker.models.Portfolio;
import com.example.portfolio_tracker.models.PortfolioItem;
import com.example.portfolio_tracker.models.Stock;
import com.example.portfolio_tracker.repository.PortfolioItemRepository;
import com.example.portfolio_tracker.repository.PortfolioRepository;
import com.example.portfolio_tracker.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private PortfolioItemRepository portfolioItemRepository;

    @Autowired
    private StockRepository stockRepository;



    public Portfolio createPortfolio(String portfolioName){
        Portfolio portfolio = new Portfolio(portfolioName);
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> getAllPortfolios(){
        List<Portfolio> portfolios = portfolioRepository.findAll();
        return portfolioRepository.findAll();

    }

    public Portfolio getPortfolioById(Long id){
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new PortfolioNotFoundException("Портфель не найден"));
    }

    public PortfolioItem buyStock(Long portfolioid, String ticker, Integer count, Double price) {
       Portfolio portfolio = getPortfolioById(portfolioid);
       Stock stock = stockRepository.findByTicker(ticker)
                .orElseThrow(() -> new StockNotFoundException("Сток с таким тикером не найден"));
       return new PortfolioItem(portfolio, stock, count, price);


    }

    public List<PortfolioItem> getPortfolioItems(Long portfolioId){
        Portfolio portfolio = getPortfolioById(portfolioId);
        return portfolioItemRepository.findByPortfolio(portfolio);
    }

    public PortfolioStats calculatePortfolioStats(Long portfolioId){
        List<PortfolioItem> items = getPortfolioItems(portfolioId);
        if (items == null){
            System.out.println("У вас нет акций");
            return null;
        }
        double totalInvestment = 0;
        double totalCurrentValue = 0;
        double totalProfitLossPercentage;
        for (PortfolioItem item : items){
            totalInvestment += item.getCount() * item.getPurchasePrice();
            totalCurrentValue  += item.getStock().getCurrentPrice() * item.getCount();
        }
        double totalProfitLoss = totalCurrentValue - totalInvestment;
        totalProfitLossPercentage = (totalProfitLoss / totalInvestment) * 100;
        return new PortfolioStats(totalInvestment, totalCurrentValue, totalProfitLoss, totalProfitLossPercentage);
    }
    public void updatePortfolioWithStock(String ticker, Double price){
        System.out.println("обновление цен в портфелях");
    }
}

