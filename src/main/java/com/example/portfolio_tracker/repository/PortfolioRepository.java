package com.example.portfolio_tracker.repository;

import com.example.portfolio_tracker.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
