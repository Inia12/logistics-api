# Logistics API

Backend REST API for managing shipments with JWT authentication and PostgreSQL database integration.

---

# Features

- JWT Authentication
- User Registration
- Protected API Endpoints
- Shipment CRUD Operations
- Pagination
- Validation
- Swagger/OpenAPI Documentation
- PostgreSQL Integration
- DTO Architecture
- Spring Security
- Exception Handling Ready Structure

---

# Technologies

- Java 17
- Spring Boot
- Spring Security
- PostgreSQL
- Hibernate / JPA
- JWT
- Maven
- Swagger / OpenAPI
- Lombok

---

# API Endpoints

## Authentication

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login and get JWT token |

---

## Shipments

| Method | Endpoint | Description |
|---|---|---|
| GET | `/shipments` | Get all shipments |
| POST | `/shipments` | Create shipment |
| PATCH | `/shipments/{id}/status` | Update shipment status |
| DELETE | `/shipments/{id}` | Delete shipment |
| GET | `/shipments/client/{name}` | Search by client |
| GET | `/shipments/status/{status}` | Search by status |

---

# Shipment Statuses

- CREATED
- IN_TRANSIT
- DELIVERED
- CANCELLED

---

# Security

This project uses JWT Bearer Authentication.

Protected endpoints require:

http
Authorization: Bearer <token>

## Database

PostgreSQL is used as the primary database.

## Example configuration:

spring.datasource.url=jdbc:postgresql://localhost:5432/logistics_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Run Project
## Clone repository
git clone https://github.com/your-username/logistics-api.git
Enter project directory
cd logistics-api
Run application
mvn spring-boot:run

# Swagger Documentation

Swagger UI:

http://localhost:8080/swagger-ui/index.html

# Example Workflow
1. Register user
2. Login
3. Copy JWT token
4. Authorize in Swagger
5. Use protected endpoints

# Project Structure
controller/
service/
repository/
model/
dto/
security/
config/

# Future Improvements
- Role-based access (ADMIN / USER)
- Docker support
- Refresh Tokens
- Global Exception Handler
- Unit Testing
- Frontend Integration
- Deployment

# Author
Sergey Ryzhak