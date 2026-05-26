# Tarefas API

This project is a simple RESTful API for managing tasks ("tarefas"). It is built with Java and the Spring Boot framework, using Spring Data JPA for persistence with a MySQL database.

## Features
- Create, Read, Update, and Delete (CRUD) operations for tasks.
- RESTful endpoints for interacting with the task data.
- Persistence using a MySQL database.

## Technologies Used
- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **Maven**
- **MySQL**

## Prerequisites
Before you begin, ensure you have met the following requirements:
- You have installed JDK 17 or later.
- You have a running instance of MySQL.
- You have Maven installed, or you will use the provided Maven Wrapper (`mvnw`).

## Getting Started

### 1. Clone the repository
```sh
git clone https://github.com/woronkoff/tarefas-api.git
cd tarefas-api
```

### 2. Configure the Database
Open the `src/main/resources/application.properties` file and update the database connection details to match your local MySQL setup:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tarefasdb?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```
The application is configured to automatically create the `tarefasdb` database if it does not exist (`createDatabaseIfNotExist=true`).

### 3. Run the Application
You can run the application using the Maven wrapper:

On macOS/Linux:
```sh
./mvnw spring-boot:run
```

On Windows:
```sh
mvnw.cmd spring-boot:run
```

The API will be available at `http://localhost:8080`.

## API Endpoints
The API provides the following endpoints for managing tasks.

The `Tarefa` object has the following structure:
```json
{
    "id": 1,
    "nome": "Finalizar projeto",
    "dataEntrega": "2024-12-31",
    "responsavel": "João Silva"
}
```

---

### Create a Task
Creates a new task.

- **URL:** `/tarefas`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
      "nome": "Implementar autenticação",
      "dataEntrega": "2025-01-15",
      "responsavel": "Maria Souza"
  }
  ```
- **Success Response:**
  - **Code:** `201 CREATED`
  - **Content:** The newly created task object.
    ```json
    {
        "id": 2,
        "nome": "Implementar autenticação",
        "dataEntrega": "2025-01-15",
        "responsavel": "Maria Souza"
    }
    ```

---

### List All Tasks
Retrieves a list of all tasks.

- **URL:** `/tarefas`
- **Method:** `GET`
- **Success Response:**
  - **Code:** `200 OK`
  - **Content:** An array of task objects.
    ```json
    [
        {
            "id": 1,
            "nome": "Finalizar projeto",
            "dataEntrega": "2024-12-31",
            "responsavel": "João Silva"
        },
        {
            "id": 2,
            "nome": "Implementar autenticação",
            "dataEntrega": "2025-01-15",
            "responsavel": "Maria Souza"
        }
    ]
    ```

---

### Get a Single Task
Retrieves a specific task by its ID.

- **URL:** `/tarefas/{id}`
- **Method:** `GET`
- **Success Response:**
  - **Code:** `200 OK`
  - **Content:** The requested task object.
- **Error Response:**
  - **Code:** `404 NOT FOUND` if the task does not exist.

---

### Update a Task
Updates an existing task by its ID.

- **URL:** `/tarefas/{id}`
- **Method:** `PUT`
- **Request Body:**
  ```json
  {
      "nome": "Atualizar documentação da API",
      "dataEntrega": "2025-01-20",
      "responsavel": "Maria Souza"
  }
  ```
- **Success Response:**
  - **Code:** `200 OK`
  - **Content:** The updated task object.
- **Error Response:**
  - **Code:** `404 NOT FOUND` if the task does not exist.

---

### Delete a Task
Deletes a task by its ID.

- **URL:** `/tarefas/{id}`
- **Method:** `DELETE`
- **Success Response:**
  - **Code:** `204 NO CONTENT`
- **Error Response:**
  - **Code:** `404 NOT FOUND` if the task does not exist.
