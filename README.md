# User Management

A learning project for exploring **Java** with **Spring Boot**. It implements a simple REST API for managing users, backed by an in-memory H2 database.

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot 4.0.5 |
| Persistence | Spring Data JPA + H2 (in-memory) |
| Build tool | Gradle 9.4.1 |
| Utilities | Lombok |

## Project Structure

```
src/main/java/com/learningspringboot/user_management/
├── UserManagementApplication.java   # Entry point
├── controller/
│   └── UserController.java          # REST endpoints
├── app/
│   └── UserService.java             # Business logic
└── infrastructure/
    ├── entitys/
    │   └── User.java                # JPA entity
    └── repository/
        └── UserRepository.java      # Spring Data repository
```

## API Endpoints

Base path: `/api/user`

| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/api/user` | Create a new user |
| `GET` | `/api/user?email={email}` | Get a user by email |
| `DELETE` | `/api/user?email={email}` | Delete a user by email |

### Example request body (POST)

```json
{
  "name": "John Doe",
  "email": "john@example.com"
}
```

## H2 Console

The in-memory H2 database console is available at [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console) while the application is running.

| Field | Value |
|---|---|
| JDBC URL | `jdbc:h2:mem:user` |
| Username | `sa` |
| Password | *(empty)* |

## How to Run

### Prerequisites

- Java 25 or later installed and available on your `PATH`

### Using the Gradle wrapper (recommended)

```bash
# Clone the repository
git clone <repository-url>
cd user-management

# Run the application
./gradlew bootRun
```

The application will start on `http://localhost:8080`.

### Build and run the JAR

```bash
# Build
./gradlew build

# Run
java -jar build/libs/user-management-0.0.1-SNAPSHOT.jar
```

### Run tests

```bash
./gradlew test
```

> **Windows users:** replace `./gradlew` with `gradlew.bat` in all commands above.

## Next Steps

This learning path builds progressively on what is already implemented here.

### Stage 1 — Strengthen the current app

- Add input validation using `@Valid` and Jakarta Bean Validation annotations (e.g. `@NotBlank`, `@Email`) on the request body
- Add centralised error handling with `@ControllerAdvice` and `@ExceptionHandler` to return structured error responses
- Write unit tests for `UserService` with JUnit 5 + Mockito, and integration tests for `UserController` with `@SpringBootTest`

### Stage 2 — Persistence & data

- Replace the in-memory H2 database with a persistent store such as PostgreSQL or MySQL
- Manage schema evolution with a migration tool (Flyway or Liquibase)
- Explore `@Query`, JPQL, and native queries in Spring Data JPA

### Stage 3 — Security & APIs

- Secure endpoints with Spring Security (authentication and role-based authorisation)
- Implement stateless authentication using JWT (JSON Web Tokens)
- Add interactive API documentation with Springdoc OpenAPI (Swagger UI)

### Stage 4 — Production readiness

- Add observability with Spring Boot Actuator and Micrometer metrics
- Containerise the application with Docker and orchestrate locally with Docker Compose
- Set up a CI/CD pipeline (e.g. GitHub Actions) and explore cloud deployment options
