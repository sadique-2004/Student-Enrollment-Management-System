# 🎓 Student Enrollment Management System

A **Java Full Stack mini-project** that performs basic **CRUD operations** for managing student records.  
This project is intentionally kept **small and focused** to strengthen core backend concepts using Java.

> 🚀 This is my **first backend project using Java**.  
> Previously, I built full-stack applications using the **MERN Stack**, and this project marks my transition into the **Java ecosystem**.

---

## 📌 Project Objective

To understand and implement:
- Java backend fundamentals
- Database connectivity using JDBC
- Request–response flow using Servlets & JSP
- End-to-end CRUD operations

---

## ✨ Features

- ➕ Add a new student  
- 📋 View all students  
- ✏️ Update student details  
- ❌ Delete a student  

> The application focuses on **functionality over UI** to prioritize backend learning.

---

## 🛠️ Tech Stack

**Backend**
- Java
- JDBC
- Servlets
- JSP

**Database**
- MySQL

**Server**
- Apache Tomcat

**Frontend (Basic)**
- HTML

---

## 🧠 Concepts Covered

- JDBC connection & CRUD queries
- Prepared Statements
- Servlet lifecycle
- HTTP request & response handling
- JSP for dynamic content rendering
- MVC-style separation (basic level)
- Database table design

---

## 📂 Project Structure (Simplified)

Student-Enrollment-System
│
├── src/
│   ├── controller/   → Servlets
│   ├── dao/          → JDBC logic
│   ├── model/        → Student entity
│
├── WebContent/
│   ├── *.jsp
│   ├── index.html
│
├── db.sql
└── README.md

---

## ⚙️ Database Setup

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  email VARCHAR(100),
  course VARCHAR(50)
);


▶️ How to Run the Project


Clone the repository


Import the project into Eclipse / IntelliJ (Dynamic Web Project)


Configure Apache Tomcat


Set up MySQL and update DB credentials in JDBC code


Run the project on the server


Open in browser:
http://localhost:8080/StudentEnrollmentSystem




📈 Future Enhancements


Form validation


Login & authentication


Better UI with CSS


Pagination & search


REST APIs


Migration to Spring Boot



👨‍💻 About Me
I come from a JavaScript & MERN Stack background, and this project represents my journey into Java backend development.
The goal is to build a strong foundation before moving to advanced frameworks like Spring & Hibernate.


This project is designed as a learning-first mini project, not a production-grade system.
Feedback and suggestions are always welcome.



# 6 Steps for JDBC

### 1st import the packages
### 2nd Load the driver
### 3rd Register the Driver
### 4th Create Connection
### 5th Create Statement
### 6th Execute Statement
### 7th Close


Then you will get the responce