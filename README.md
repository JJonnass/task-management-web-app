# ✅ TaskMaster – Task Management Web App with Spring Boot

**TaskMaster** is a full-stack task management web application built using **Java Spring Boot**. It allows authenticated users to manage tasks efficiently with basic CRUD functionality. The app is secured using Spring Security and is ready for deployment via Docker.

---

## Features

- Create, read, update, and delete tasks
- User authentication with Spring Security
- Modular MVC structure (Controller, Model, Service)
- REST API structure for potential front-end use
- Docker-ready for containerized deployment
- Scalable and maintainable Java backend design

---

## 🛠️ Tech Stack

| Technology         | Purpose                            |
|--------------------|------------------------------------|
| Java 17+           | Primary programming language        |
| Spring Boot        | Backend framework (REST + Web MVC) |
| Spring Security    | User authentication & access       |
| Maven              | Dependency and build management     |
| Docker             | Containerization and deployment     |

---

## 📁 Project Structure

```
TaskMaster/
├── src/
│ └── main/
│ ├── java/
│ │ └── haagahelia/
│ │ └── fi/
│ │ └── TaskMaster/
│ │ ├── Controller/
│ │ │ ├── TaskMasterController.java
│ │ │ └── UserDetailServiceImpl.java
│ │ ├── Model/
│ │ ├── WebSecurityConfig.java
│ │ └── TaskMasterApplication.java
│ └── resources/
│ ├── application.properties
│ └── templates/ (if using Thymeleaf)
├── Dockerfile
├── pom.xml
└── README.md
```
## ▶️ Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- Docker (optional, for containerized run)

---

### Run Locally (with Maven)

```bash
# Clone the repository
git clone https://github.com/JJonnass/task-management-web-app.git
cd TaskMaster

# Build and run the app
mvn spring-boot:run
```
---
## Run with Docker
```bash
# Build Docker image
docker build -t taskmaster-app .

# Run container
docker run -p 8080:8080 taskmaster-app
```
---
## Authentication
The application uses Spring Security to manage login and session security. Default login setup can be modified in WebSecurityConfig.java
---
## Future Improvements
- Front-end integration (React, Angular, or Thymeleaf)
- Role-based access control
- Task filtering by user/date/status
- Database integration
---
## License
This project is intended for learning and portfolio purposes only.

