# SEG 3103 Final Project: Full-Stack URL Shortener

This project is a small, self-contained URL shortener application built to demonstrate various software testing tools.

It consists of:

- A **Java (Spring Boot)** backend providing the API.
- A **React** frontend for user interaction.
- **K6** scripts for load testing for me (Elias)

## How to Run the Application

### Prerequisites

- Java 21+ and Maven 3.8+
- Node.js 18+ and npm

### 1. Run the Backend

1. Make sure that all maven packages have been synced.
2. Open a terminal in the root directory:
3. Simply click the play button located in the top-right of IntelliJ.

Or, from the root of the directory execute the following command:

```bash
# Run the Spring Boot application
mvn spring-boot:run
```

The backend will be running at `http://localhost:8080`.

### 2. Run the Frontend

Open a second terminal in the `frontend` directory:

```bash
# Navigate to the frontend directory
cd frontend

# Install dependencies
npm install

# Start the React development server
npm start
```

The frontend will open automatically at `http://localhost:3000`.

### UI Testing

The frontend includes `data-testid` attributes on all key elements (`url-input`, `submit-button`, `url-list`) to make it easy to write UI tests using tools like Cypress, Playwright, or Selenium.

### Load Testing Configuration (Rate Limiting)

To demonstrate load testing scenarios (e.g., a passing vs. a failing test), the backend includes a configurable, artificial bottleneck. This can be controlled via the src/main/resources/application.properties file.

```bash
# Set to true to artificially limit concurrent requests and slow down the server.
# Set to false for the application to run at full speed.
rate-limiting.enabled=true

# If rate-limiting.enabled is true, this sets the maximum number of
# concurrent requests the server will handle.
rate-limiting.permits=10
rate-limiting.enabled:
```

`rate-limiting.enabled`:

- When `true`, a semaphore is used to limit concurrent requests to the shortenUrl endpoint, and an artificial delay is added to simulate a slow process. This is used to make a load test fail.

- When `false`, the application runs at full speed with no artificial limits. This is used to make a load test pass.

`rate-limiting.permits:` Sets the number of allowed concurrent requests when rate limiting is enabled.
