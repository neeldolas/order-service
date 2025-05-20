# 🛒 DineGrid Order Service

The **Order Service** is a core service within the **DineGrid Food Ordering Microservices Platform**. It handles order creation, price fetching from the Menu Service, communicates asynchronously via Kafka, and persists orders in MongoDB.

---

## 📦 Tech Stack:
- Java 21
- Spring Boot 3.4.x
- Spring Data MongoDB
- Spring Web
- Spring Kafka
- Lombok
- MapStruct
- Springdoc OpenAPI (Swagger)

---

## 🚀 REST Endpoints:

| Method | Endpoint                   | Description                                   |
|:--------|:----------------------------|:------------------------------------------------|
| `GET`   | `/api/v1/order`             | Retrieve all orders                           |
| `POST`  | `/api/v1/order`             | Place a new order                              |
| `GET`   | `/api/v1/order/{id}`        | Get order details by order ID                  |
| `GET`   | `/api/v1/order/user/{userId}`| Fetch all orders placed by a specific user     |
| `DELETE`| `/api/v1/order/{id}`        | Delete an order by order ID                    |

---

## ⚙️ Features:
- **Place Order** — Validates user and menu item existence, calculates total, saves to MongoDB.
- **MongoDB Persistence** — Document-based storage for flexible order structures.
- **Kafka Integration** — Publishes `order-events` topic when an order is placed.
- **Kafka Consumer in Menu Service** — Updates menu item quantity based on placed orders.
- **DTO Mapping via MapStruct** — Clean conversion between entities, DTOs and responses.
- **Dockerized Deployment** — Service containerized via docker-compose alongside other services.

---

## 📑 Notes:
- No authentication enforced (internal-only API for now).
- Swagger UI available at: `http://localhost:8083/swagger-ui.html`
- Runs within Docker alongside:
  - MongoDB
  - Kafka & Zookeeper (for event messaging)
  - Menu Service & User Service (via docker-compose)

---

## 🐳 Run with Docker Compose:

```bash
docker-compose up --build -d
