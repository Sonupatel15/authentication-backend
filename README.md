# Authentication Backend Service

This repository contains the backend service for authentication and post management, built with Spring Boot. It utilizes in-memory storage for simplicity and implements a custom authentication filter for securing API endpoints.

## Prerequisites

Before running this application, ensure you have the following installed:

-   **Java Development Kit (JDK) 17 or later:** You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.java.net/).
-   **Maven (>= 3.6.0):** You can download it from [Apache Maven](https://maven.apache.org/download.cgi).
-   **Postman or cURL:** For testing API endpoints.

## Getting Started

1.  **Clone the Repository:**

    ```bash
    git clone https://github.com/Sonupatel15/authentication-backend.git
    cd authentication-backend
    ```

2.  **Build the Application:**

    Use Maven to build the project:

    ```bash
    mvn clean install
    ```

3.  **Run the Application:**

    Run the Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

    The application will start on port `8081` as configured in `application.properties`. You can modify this port if needed.

## API Endpoints

### 1. Create a Post

-   **Endpoint:** `POST /post`
-   **Method:** `POST`
-   **Headers:**
    -   `Content-Type: application/json`
    -   `PinggyAuthHeader: <your_auth_header>` (Required)
-   **Request Body:**

    ```json
    {
      "title": "Sample Post",
      "body": "This post detailed insights about full stack development"
    }
    ```

-   **Response:**
    -   **Success:** `200 OK` with the message "Post saved successfully".
    -   **Failure:** `400 Bad Request` if the request body is invalid (e.g., missing title or body). `401 Unauthorized` if the `PinggyAuthHeader` is missing or empty.

**Postman Testing:**
<img width="996" alt="post" src="https://github.com/user-attachments/assets/00db5d36-7a6a-446b-8fec-dab6787e25ad" />

### 2. Get All Posts

-   **Endpoint:** `GET /list`
-   **Method:** `GET`
-   **Response:**
    -   **Success:** `200 OK` with a JSON array of `PostResponseDTO` objects.
-   **Example Response:**

    ```json
    [
      {
        "title": "Sample Post",
        "body": "This is my first post content.",
        "pinggyAuthHeader": "your_secret_auth_token"
      }
      // ... more posts
    ]
    ```

**Postman Testing:**
<img width="1009" alt="get" src="https://github.com/user-attachments/assets/7fa4341a-cff8-4854-b5c4-62d0237c5489" />

## Authentication

This backend uses a custom authentication filter (`CustomAuthFilter`) to secure API endpoints. All requests to the `/post` endpoint require a `PinggyAuthHeader` in the request headers.

-   If the `PinggyAuthHeader` is missing or empty, the server returns a `401 Unauthorized` error.
-   The authentication header is stored in a `ThreadLocal` variable and included in the response of the `/list` endpoint for demonstration purposes.

## Error Handling

The application uses a custom exception handler (`CustomExceptionHandler`) to handle validation errors.

-   If the request body for the `/post` endpoint is invalid, the server returns a `400 Bad Request` error with a JSON object containing the validation errors.

## In-Memory Storage

The application uses an in-memory storage (`InMemoryStorage`) to store posts. This means that all data will be lost when the application restarts. For production environments, consider using a persistent database.

## Configuration

The application can be configured using the `application.properties` file.

-   `server.port`: The port on which the application runs (`8081`).

## Dependencies

-   **Spring Boot Web:** For building web applications.
-   **Lombok:** For reducing boilerplate code.
-   **Spring Validation:** For request body validation.

## Frontend Integration

If you need a frontend to interact with this backend, you can find one here: https://github.com/Sonupatel15/authentication-frontend
