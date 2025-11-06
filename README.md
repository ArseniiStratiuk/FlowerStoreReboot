# Flower Store Demo

Spring Boot application with PostgreSQL backend exposing REST APIs for browsing flowers, simulating deliveries/payments, and creating demo orders.

## Quick Start

### Using Docker Compose (Recommended)
```bash
cd lab7
docker-compose up -d  # Start PostgreSQL
./mvnw spring-boot:run
```

### Manual PostgreSQL Setup
```bash
docker run --name oop-course \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=flowerstore \
  -d -p 5432:5432 postgres
cd lab7
./mvnw spring-boot:run
```

Application listens on `http://localhost:8080`.

## API Endpoints

| Method | Path | Description |
| ------ | ---- | ----------- |
| GET | `/api/v1/flower` | Get all flowers from database |
| POST | `/api/v1/flower` | Create a new flower |
| GET | `/api/v1/flower/type/{type}` | Get first flower of specific type |
| GET | `/api/v1/delivery` | List available delivery methods |
| GET | `/api/v1/delivery/simulate` | Simulate delivery |
| GET | `/api/v1/payment` | List available payment methods |
| GET | `/api/v1/payment/simulate` | Simulate payment |
| POST | `/api/orders` | Process an order |

## Testing with test.http

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
- IntelliJ IDEA: Open the file and click the green play button next to each request
- VS Code: Install the "REST Client" extension by Huachao Mao, then click "Send Request" above each `###` section

## Example curl Commands

```bash
# Get all flowers
curl http://localhost:8080/api/v1/flower

# Create a flower (description auto-generated as "ROSE flower")
curl -X POST http://localhost:8080/api/v1/flower \
  -H "Content-Type: application/json" \
  -d '{"type":"ROSE","color":"RED","sepalLength":2.5,"price":12.99}'

# Simulate delivery
curl "http://localhost:8080/api/v1/delivery/simulate?method=dhl&itemType=ROSE"

# Process order
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{"items":["ROSE","TULIP"],"payment":"paypal","delivery":"post"}'
```

## Database Schema

The `flowers` table has these columns:
- `id` - Auto-generated primary key (BIGSERIAL)
- `description` - Auto-generated from type (e.g., "ROSE flower") - **NOT NULL**
- `flower_type` - Flower species - **NOT NULL**
- `color` - Visual color - **NOT NULL**
- `sepal_length` - Decimal value in centimeters
- `price` - Decimal value - **NOT NULL**

**Important:** When creating flowers via the REST API, the `description` is automatically set based on the `type` field (e.g., `"ROSE"` → `"ROSE flower"`). You don't need to provide it in the JSON payload.

### Resetting the Database

If you encounter errors like "null value in column 'description'", your database schema is outdated. Reset it:

```bash
cd lab7
docker-compose down -v     # Delete volume and all data
docker-compose up -d       # Restart with fresh database
./mvnw spring-boot:run     # Recreate schema and seed data
```

### Manual SQL in DBeaver

If inserting flowers manually via SQL, include the description and use valid enum values:

```sql
-- Correct way (must use exact enum values: RED, GREEN, BLUE, WHITE, YELLOW)
INSERT INTO flowers (flower_type, color, sepal_length, price, description)
VALUES ('ROSE', 'RED', 2.3, 15.0, 'ROSE flower');

-- Or let the API handle it (recommended - validates automatically)
```

## Running Tests

```bash
cd lab7
./mvnw test              # Run all tests
./mvnw checkstyle:check  # Check code style
```

## Architecture

- **API Layer**: REST controllers in `com.web.lab7.controller`
- **Service Layer**: Business logic in `com.web.lab7.service`
- **Data Access Layer**: JPA repositories in `com.web.lab7.repository`
- **Database**: PostgreSQL with JPA/Hibernate
- **Patterns**: Strategy (Payment/Delivery), Decorator (Item decorators)
