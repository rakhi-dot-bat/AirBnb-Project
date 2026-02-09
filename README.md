# 🏨 Airbnb Clone – Backend (Spring Boot)

A production-style Airbnb-like backend application built using Java & Spring Boot, focusing on clean architecture, RESTful APIs, security, and real-world backend practices.

This project simulates core Airbnb features such as hotel management, bookings, users, and admin operations, designed to be scalable.

---

## 🚀 Features

- Add, view, update, and delete books
- RESTful APIs built with Spring Boot
- Input validation using Hibernate Validator
- Global exception handling
- In-memory H2 database (easy to switch to MySQL)
- API documentation via Swagger UI
- Unit testing with JUnit & Mockito
- 
🔐 Authentication & Authorization
- JWT-based authentication
- Role-based access control (ADMIN / USER)
- Secure endpoints using Spring Security

🏨 Hotel Management (Admin)
- Create hotel
- Get hotel by ID
- Update hotel (PUT & PATCH)
- Delete hotel

📄 RESTful API Design
- Proper HTTP methods (GET, POST, PUT, PATCH, DELETE)
- Clean URL structure
- Centralized exception handling
- Input validation using @Valid

📘 API Documentation
- Swagger UI for easy API exploration
- OpenAPI 3.0 compliant

---

## 🛠 Tech Stack

| Technology     | Details                              |
|----------------|--------------------------------------|
| Java           | 21                                   |
| Spring Boot    | 3.5.3                                |
| Spring Data JPA| ORM & database interaction           |
| Database       | PostgresSQL (can switch to MySQL)    |
| API Docs       | Swagger / Springdoc OpenAPI          |
| Testing        | JUnit, Mockito              |
| Build Tool     | Maven                       |
| IDE            | IntelliJ IDEA               |

---

## 📁 Project Structure
book-management/
com.airbnb.clone├── controller
├── service
├── service.impl
├── repository
├── entity
├── dto
├── security
├── exception
├── config

---

📦 API Endpoints

| Method	   |   Endpoint	                 |     Description            |
|------------|-----------------------------|----------------------------|
| POST       |  /admin/hotels	             |     Create hotel           |
| GET	       |  /admin/hotels/{hotelId}	   |     Get hotel by ID        |
| PATCH	     |  /admin/hotels/{hotelId}	   |     Partial update hotel   |
| DELETE	   |  /admin/hotels/{hotelId}	   |     Delete hotel    |
| PUT        |  /admin/hotels/{hotelId}	   |     Full update hotel   |

---
⚠️ Global Exception Handling

- Centralized exception handling using @ControllerAdvice
- Meaningful error responses
- Proper HTTP status codes
---

🧰 Tools Used

Postman – API testing

Swagger UI – View and test API docs: localhost:8080/api/v1/swagger-ui/index.html

---

Swagger UI Screenshots


---
📌 Future Enhancements

Booking management

User reviews & ratings

Search & filters

Payment gateway integration

Caching with Redis

Deployment using Docker & AWS
----
📚 Learning Outcomes

By building this Airbnb Clone backend project, I gained hands-on experience with:

Designing RESTful APIs using Spring Boot following industry best practices

Implementing JWT-based authentication and authorization with Spring Security

Applying role-based access control (RBAC) for ADMIN and USER roles

Structuring a project using clean layered architecture (Controller, Service, Repository)

Working with Spring Data JPA & Hibernate for database interactions

Handling CRUD operations with proper HTTP methods (GET, POST, PUT, PATCH, DELETE)

Implementing global exception handling using @ControllerAdvice

Performing input validation using @Valid and custom validation annotations

Integrating and configuring Swagger / OpenAPI for API documentation

Debugging common backend issues such as 500 errors, validation failures, and security blocks

Writing scalable and maintainable code suitable for real-world applications

Understanding how production-ready backend systems are designed and extended
