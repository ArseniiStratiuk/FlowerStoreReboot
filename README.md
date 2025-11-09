# Flower Store Application

Spring Boot REST API for a flower store with user management, order processing, and delivery/payment simulations.

**Live Demo:** [https://flower-store-reboot-oop-ad9a74de098a.herokuapp.com](https://flower-store-reboot-oop-ad9a74de098a.herokuapp.com)

## Features

- **Flower Catalog** - Browse and manage flowers with types (Rose, Tulip, Romashka, Cactus)
- **User Management** - Register users with email validation and auto-calculated age
- **Order Processing** - Create orders with delivery and payment strategies
- **Delivery Simulation** - Post and DHL delivery options
- **Payment Simulation** - Credit card and PayPal payment methods
- **PostgreSQL Database** - Full persistence with JPA/Hibernate
- **Design Patterns** - Strategy pattern (delivery/payment), Decorator pattern (item decorators)

## Quick Start

### Local Development

```bash
cd lab7

# Start PostgreSQL
docker-compose up -d

# Run application
./mvnw spring-boot:run

# Application runs at http://localhost:8080
```

### Heroku Deployment

Application is deployed at: **https://flower-store-reboot-oop-ad9a74de098a.herokuapp.com**

## API Endpoints

### Flowers
| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/v1/flower` | Get all flowers |
| POST | `/api/v1/flower` | Create a new flower |
| GET | `/api/v1/flower/type/{type}` | Get flower by type |

### Users
| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/v1/users` | Get all users |
| POST | `/api/v1/users` | Register a new user |

### Orders & Services
| Method | Path | Description |
|--------|------|-------------|
| POST | `/api/orders` | Create an order |
| GET | `/api/v1/delivery` | List delivery methods |
| GET | `/api/v1/delivery/simulate` | Simulate delivery |
| GET | `/api/v1/payment` | List payment methods |
| GET | `/api/v1/payment/simulate` | Simulate payment |

## Testing the API

### Quick Test Commands

```bash
# Heroku (Live)
HEROKU_URL="https://flower-store-reboot-oop-ad9a74de098a.herokuapp.com"

# Get all flowers
curl $HEROKU_URL/api/v1/flower

# Create a user
curl -X POST $HEROKU_URL/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","dob":"2000-01-15"}'

# Get all users
curl $HEROKU_URL/api/v1/users

# Create a flower
curl -X POST $HEROKU_URL/api/v1/flower \
  -H "Content-Type: application/json" \
  -d '{"type":"ROSE","color":"RED","sepalLength":2.5,"price":15.99}'

# Create an order
curl -X POST $HEROKU_URL/api/orders \
  -H "Content-Type: application/json" \
  -d '{"items":["ROSE","TULIP"],"payment":"credit-card","delivery":"dhl"}'
```

### Using test.http File

Create a `test.http` file in your project root with these requests:

```http
### Get all flowers
GET http://localhost:8080/api/v1/flower

### Get flower by type
GET http://localhost:8080/api/v1/flower/type/ROSE

### Create a new flower (description is auto-generated from type)
POST http://localhost:8080/api/v1/flower
Content-Type: application/json

{
  "type": "ROSE",
  "color": "RED",
  "sepalLength": 2.5,
  "price": 12.99
}

### List delivery methods
GET http://localhost:8080/api/v1/delivery

### Simulate delivery
GET http://localhost:8080/api/v1/delivery/simulate?method=dhl&itemType=ROSE

### List payment methods
GET http://localhost:8080/api/v1/payment

### Simulate payment
GET http://localhost:8080/api/v1/payment/simulate?method=credit-card&amount=100

### Create an order
POST http://localhost:8080/api/orders
Content-Type: application/json

{
  "items": ["ROSE", "TULIP"],
  "payment": "credit-card",
  "delivery": "dhl"
}
```

**Using test.http in IntelliJ IDEA / VS Code:**
- IntelliJ IDEA: Open [`lab7/test.http`](lab7/test.http) and click the green play button next to each request
- VS Code: Install the "REST Client" extension, open [`lab7/test.http`](lab7/test.http), click "Send Request"

The test.http file includes examples for both local and Heroku environments.

## Database Schema

**Available Types:** `ROSE`, `TULIP`, `ROMASHKA`, `CACTUS`  
**Available Colors:** `RED`, `GREEN`, `BLUE`, `WHITE`, `YELLOW`

**Note:** `description` is auto-generated from type ("ROSE flower")

### Users Table (`app_users`)

**Key Features:**
- `email` has UNIQUE constraint (prevents duplicates)
- `age` is calculated dynamically from `dob` using `@Transient` (not stored in DB)
- Age calculation: `Period.between(dob, LocalDate.now()).getYears()`

### Database Inspection

**DBeaver Connection:**
```
Host: localhost
Port: 5432
Database: flowerstore
Username: postgres
Password: postgres
```

## Architecture

**Design Patterns:**
- **Strategy Pattern**: Delivery (Post, DHL) and Payment (CreditCard, PayPal) strategies
- **Decorator Pattern**: Item decorators (Paper, Basket, Ribbon) for price calculation
- **DTO Pattern**: Request/Response objects for API layer
- **Repository Pattern**: JPA repositories for data access

## Technologies Used

- **Backend**: Spring Boot 3.5.7, Java 17
- **Database**: PostgreSQL 16 (via Testcontainers for tests, Docker Compose for local, Heroku Postgres for production)
- **ORM**: Hibernate/JPA
- **Testing**: JUnit 5, Spring Boot Test, Testcontainers
- **Build**: Maven
- **Code Quality**: Checkstyle
- **Deployment**: Heroku
- **CI/CD**: GitHub Actions
