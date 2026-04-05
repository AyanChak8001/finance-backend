# 💰 Finance Backend API (Spring Boot)

A robust and scalable backend application for managing financial records such as income and expenses. Built using Spring Boot and PostgreSQL, this project provides RESTful APIs for CRUD operations, filtering, and dashboard analytics.

---

## 🚀 Features

* ✅ Create, Read, Update, Delete (CRUD) financial records
* ✅ Filter records by type (INCOME / EXPENSE)
* ✅ Dashboard summary (Total Income, Expense, Net Balance)
* ✅ PostgreSQL database integration
* ✅ Clean layered architecture (Controller → Service → Repository)
* ✅ Global Exception Handling
* ✅ Input validation using DTOs

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot 3
* Spring Data JPA (Hibernate)
* PostgreSQL
* Maven
* Postman (API testing)

---

## 📂 Project Structure

```
com.finance.Backend
│
├── controller        # REST Controllers
├── service           # Business Logic
├── repository        # JPA Repositories
├── model             # Entity Classes
├── dto               # Request DTOs
├── exception         # Exception Handling
├── security          # Security Config (disabled for testing)
└── FinanceBackendApplication.java
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```
git clone https://github.com/YOUR_USERNAME/finance-backend.git
cd finance-backend
```

---

### 2️⃣ Configure Database

Make sure PostgreSQL is installed and running.

Create database:

```
CREATE DATABASE finance_db;
```

---

### 3️⃣ Update application.properties

```
spring.datasource.url=jdbc:postgresql://localhost:5432/finance_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

### 4️⃣ Run Application

Run the main class:

```
FinanceBackendApplication.java
```

Server starts at:

```
http://localhost:8080
```

---

## 📡 API Endpoints

### 🔹 Financial Records

| Method | Endpoint                          | Description     |
| ------ | --------------------------------- | --------------- |
| POST   | `/api/records`                    | Create record   |
| GET    | `/api/records`                    | Get all records |
| GET    | `/api/records/filter/type/{type}` | Filter by type  |
| PUT    | `/api/records/{id}`               | Update record   |
| DELETE | `/api/records/{id}`               | Delete record   |

---

### 🔹 Dashboard

| Method | Endpoint                 | Description |
| ------ | ------------------------ | ----------- |
| GET    | `/api/dashboard/summary` | Get summary |

---

## 🧪 Sample Request

### POST /api/records

```
{
  "amount": 5000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-06",
  "description": "Monthly salary"
}
```

---

## 📊 Sample Response

```
{
  "income": 6000,
  "expense": 0,
  "netBalance": 6000
}
```

---

## ⚠️ Notes

* Security is disabled (`permitAll()`) for easier testing
* Tables are auto-created using Hibernate
* PostgreSQL is used as the primary database

---

## 👨‍💻 Author

**Ayan Chakraborty**

---

## ⭐ Future Improvements

* Add JWT Authentication
* Add pagination & sorting
* Dockerize application
* Add unit & integration tests

---

## 📌 Conclusion

This project demonstrates backend development skills including REST API design, database integration, clean architecture, and exception handling using Spring Boot.

---
