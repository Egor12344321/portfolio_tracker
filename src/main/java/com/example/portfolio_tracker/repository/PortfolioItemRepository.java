package com.example.portfolio_tracker.repository;

import com.example.portfolio_tracker.models.Portfolio;
import com.example.portfolio_tracker.models.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
    List<PortfolioItem> findByPortfolio(Portfolio portfolio);
}
