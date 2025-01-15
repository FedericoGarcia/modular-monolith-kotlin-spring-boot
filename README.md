# Modular monolith with Kotlin and Spring Boot

## Prerequisites

1. Install the following tools:
    - Docker
    - Docker Compose
2. Create a `.env` file in the root of the project.

## Running the application

### Development

```bash
docker compose up --build development --watch
```

### Production

```bash
docker compose up --build production
```

## Running the tests

```bash
docker compose up --build test
```
