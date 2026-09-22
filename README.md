# 💰 Expense Tracker API

A RESTful Expense Tracker API built with **Java, Spring Boot, Spring Data JPA, and MySQL**.

This project is being developed step-by-step to strengthen my backend development skills and understand how real-world REST APIs are designed.

---

## 🚀 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST API
- Postman
- Git & GitHub

---

## ✨ Current Features

- Create an expense
- Get all expenses
- Get an expense by ID
- Update an expense
- Soft-delete architecture using a `delete` flag
- MySQL database integration
- RESTful API structure

---

## 📌 API Endpoints

| Method | Endpoint | Description | Status |
|--------|----------|-------------|--------|
| `POST` | `/expenses` | Create a new expense | ✅ |
| `GET` | `/expenses` | Get all expenses | ✅ |
| `GET` | `/expenses/{id}` | Get expense by ID | ✅ |
| `PUT` | `/expenses/{id}` | Update an expense | ✅ |
| `DELETE` | `/expenses/{id}` | Soft delete an expense | 🚧 |

---

## 🏗️ Project Architecture

The application follows a layered architecture:

```text
Controller
     ↓
Service
     ↓
Repository
     ↓
Database
