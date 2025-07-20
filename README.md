BASIC AUTH STORE

A demo project showcasing Spring Security Basic Authentication using JSESSIONID for session management. This is a simple online store where users can register, authenticate, and purchase articles.

Features

Basic Authentication with Spring Security
Password hashing with BCrypt
Custom AuthenticationProvider using database-backed user tables
Three user roles with different privileges:
USER: Registered customers
ADMIN: Fixed admin account (admin@example.it / admin)
TRACK: Responsible for order tracking (track@example.it / track)
User Roles & Accounts

Role	Description	Email	Password
USER	Regular users who must register	-	-
ADMIN	Administrator with full privileges	admin@example.it	admin
TRACK	Order tracking operator	track@example.it	track
Overview

This project demonstrates a basic authentication mechanism built with Spring Security, featuring:

Secure password storage using BCrypt
A custom authentication provider with user data stored in database tables
Role-based access control using annotations (@PreAuthorize)
Session management via JSESSIONID
It serves as a foundational example for building authentication in real-world applications.

⚠️ Important Notes
While Basic Authentication is still used for the initial login (sending credentials via HTTP headers), after successful authentication:

A JWT token is generated and returned to the client
All subsequent requests must include the JWT in the Authorization header (e.g., Authorization: Bearer <token>)
This approach ensures statelessness and is more scalable than traditional session-based login

Getting Started

Prerequisites

Java 17+
Maven or Gradle
A configured relational database (MySQL, H2)
Running the Application

Clone the repository:

git clone https://github.com/simonemene/basic-auth-store.git
Run the Spring Boot backend: ./mvnw spring-boot:run Or, if Maven is installed globally: 'mvn spring-boot:run'

Run the Angular frontend: Navigate to the frontend directory: cd frontend npm install npm start

🐳 Option 2: Run with Docker Compose

Make sure Docker and Docker Compose are installed. From the root of the project, run (docker-compose.yml): docker compose up --build

Feel free to open issues or submit pull requests if you have suggestions or improvements!
