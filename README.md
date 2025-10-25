# Portfolio Tracker API

Spring Boot REST API для управления инвестиционным портфелем. Планируется добавлениие WebSocket 
для автоматического обновления стоимости акций, увеличение количества функций, работа с безопасностью.

## Функционал
- Создание портфелей
- Добавление/просмотр акций
- Покупка акций в портфель
- Расчет прибыли и статистики
- Аутентификация JWT
- Отслеживание цен акций в реальном времени через WebSocket


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
portfolio_tracker/
├── src/
│   ├── main/
│   │   ├── java/com/example/portfolio_tracker/
│   │   │   ├── config/
│   │   │   │   ├── JwtAuthFilter.java
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   └── WebSocketConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── PortfolioController.java
│   │   │   │   ├── StockController.java
│   │   │   │   ├── TestController.java
│   │   │   │   └── WebSocketController.java
│   │   │   ├── dto/
│   │   │   │   ├── LoginRequest.java
│   │   │   │   ├── PortfolioItemUpdate.java
│   │   │   │   ├── PortfolioStats.java
│   │   │   │   ├── PortfolioUpdate.java
│   │   │   │   ├── RegistrationRequest.java
│   │   │   │   └── StockPriceUpdate.java
│   │   │   ├── exceptions/
│   │   │   │   ├── BusinessException.java
│   │   │   │   ├── PortfolioNotFoundException.java
│   │   │   │   └── StockNotFoundException.java
│   │   │   ├── models/
│   │   │   │   ├── Portfolio.java
│   │   │   │   ├── PortfolioItem.java
│   │   │   │   ├── Stock.java
│   │   │   │   └── User.java
│   │   │   ├── repository/
│   │   │   │   ├── PortfolioItemRepository.java
│   │   │   │   ├── PortfolioRepository.java
│   │   │   │   ├── StockRepository.java
│   │   │   │   └── UserRepository.java
│   │   │   ├── service/
│   │   │   │   ├── AuthService.java
│   │   │   │   ├── PortfolioService.java
│   │   │   │   ├── StockService.java
│   │   │   │   ├── UserDetailsImpl.java
│   │   │   │   ├── UserDetailsServiceImpl.java
│   │   │   │   └── WebSocketService.java
│   │   │   └── util/
│   │   │       ├── JwtUtils.java
│   │   │       └── PortfolioTrackerApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       └── application.properties
├── target/
├── .gitignore
├── .gitattributes
├── HELP.md
├── mvnw
└── pom.xml

