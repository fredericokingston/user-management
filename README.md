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
