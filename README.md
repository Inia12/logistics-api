# Logistics API

Backend service for managing shipments.

## Technologies

- Java
- Spring Boot
- PostgreSQL
- Hibernate / JPA
- Maven

## Features

- Create shipment
- Get all shipments
- Search shipments by client
- Search shipments by status
- Update shipment status
- Delete shipment

## API Endpoints

POST /shipments  
GET /shipments  
GET /shipments/client/{name}  
GET /shipments/status/{status}  
GET /shipments/{id}/status  
DELETE /shipments/{id}

## Database

PostgreSQL

## Run project

```bash
mvn spring-boot:run