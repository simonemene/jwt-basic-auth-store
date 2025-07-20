# 🛒 JWT BASIC AUTH STORE

A demo project showcasing **Spring Security Basic Authentication combined with JWT (JSON Web Token)** for stateless authentication. This is a simple online store where users can register, authenticate, and purchase articles.

---

## 🔐 Features

- Basic Authentication with Spring Security
- Token-based authentication with **JWT**
- Password hashing using **BCrypt**
- Custom `AuthenticationProvider` using a database-backed user table
- Role-based access control with `@PreAuthorize`
- Stateless session management (no JSESSIONID)

---

## 👥 User Roles & Accounts

| Role  | Description                   | Email                | Password |
|-------|-------------------------------|----------------------|----------|
| USER  | Regular users (self-register) | -                    | -        |
| ADMIN | Administrator                 | admin@example.it     | admin    |
| TRACK | Order tracking operator       | track@example.it     | track    |

---

## 🧭 Overview

This project demonstrates a modern authentication flow using Spring Security with Basic Auth and JWT:

- Users authenticate via Basic Auth (email/password)
- Upon successful login, a **JWT** is issued
- All subsequent requests require the JWT in the `Authorization` header:
- The backend validates the token and applies role-based access control

This approach avoids traditional session tracking (like `JSESSIONID`) and improves scalability by using stateless authentication.

---

## ⚠️ Security Notice

While Basic Auth is used to send credentials, it is **only used once** to obtain a JWT. The token is then used for further communication. However, keep in mind:

- Always use **HTTPS** in production
- Store the token securely (e.g., in memory, or HttpOnly cookie if extended)
- Implement **token expiration and refresh** for added security

> This is a demo project and **not production-ready**. For more robust security, consider implementing refresh tokens and using secure storage mechanisms.

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 17+
- Maven or Gradle
- A configured relational database (e.g., MySQL or H2)
- Node.js & npm (for the frontend)

---

### ▶️ Running the Application

#### Option 1: Manual Run

```bash
# Clone the repository
git clone https://github.com/simonemene/basic-auth-store.git
cd basic-auth-store
```

Run the Spring Boot backend:

```bash
./mvnw spring-boot:run
# or, if Maven is installed globally
mvn spring-boot:run
```

Run the Angular frontend:

```bash
cd frontend
npm install
npm start
```

🐳 Option 2: Docker Compose

If you have Docker and Docker Compose installed:

docker compose up --build

🤝 Contributing

Feel free to open issues or submit pull requests if you have suggestions or improvements!

