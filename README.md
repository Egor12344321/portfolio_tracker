# Portfolio Tracker API

Spring Boot REST API для управления инвестиционным портфелем. Планируется добавлениие WebSocket 
для автоматического обновления стоимости акций, увеличение количества функций, работа с безопасностью.

## Функционал
- Создание портфелей
- Добавление/просмотр акций
- Покупка акций в портфель
- Расчет прибыли и статистики

## Технологии
- Java 21, Spring Boot 3
- PostgreSQL, Spring Data JPA
- REST API, Maven

## API Endpoints
- `GET /api/stocks` - получить все акции
- `POST /api/stocks` - добавить акцию
- `GET /api/portfolios` - все портфели
- `POST /api/portfolios` - создать портфель
- `GET /api/portfolios/{id}/items` - позиции портфеля
- `POST /api/portfolios/{id}/buy` - купить акцию
- `GET /api/portfolios/{id}/stats` - статистика портфеля

## Структура проекта
portfolio-tracker/
├── src/main/java/com/example/portfolio_tracker/
│   ├── PortfolioTrackerApplication.java (запуск проекта)
│   ├── controller/
│   │   ├── PortfolioController.java (обаботчики эндпоинтов)
│   │   └── StockController.java
│   ├── service/
│   │   ├── PortfolioService.java (методы, выполняющие эндпоинты)
│   │   └── StockService.java
│   ├── repository/
│   │   ├── PortfolioRepository.java (работа с бд)
│   │   ├── StockRepository.java
│   │   └── PortfolioItemRepository.java
│   ├── models/
│   │   ├── Portfolio.java (сущности)
│   │   ├── Stock.java
│   │   └── PortfolioItem.java
│   └── dto/
│       └── PortfolioStats.java (вывод статистики портфеля на основе айтемов портфеля)
├── src/main/resources/
│   └── application.properties
├── pom.xml
└── README.md


