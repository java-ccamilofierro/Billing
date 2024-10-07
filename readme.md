# Billing Microservice

## Description
This project is a billing microservice developed with Spring Boot. It provides functionalities to create, read, update, and delete invoices, as well as perform custom queries.

## Features
- Full CRUD for invoices
- Custom queries using `@Query`
- Custom exception handling
- API documentation with Swagger/OpenAPI
- Data persistence with JPA and Hibernate
- MySQL database connection

## Prerequisites
- Java 17
- Maven 3.3.4
- MySQL 8

## Setup
1. Clone the repository:
```git
git clone https://github.com/java-ccamilofierro/Billing.git
```

2. Configure the MySQL database in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/billing
spring.datasource.url=jdbc:mysql://localhost:3306/billing_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Run the SQL script to create the database (if necessary):
```sql
CREATE DATABASE billing_db;
```

## Execution

1. Navigate to the project directory:

```plaintext
cd billing-microservice
```

2. Build the project:

```plaintext
mvn clean install
```

3. Run the application:

```plaintext
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## API Usage

You can access the Swagger UI documentation at `http://localhost:8080/swagger-ui.html` to view and test all available endpoints.

Examples of endpoints:

- GET `/api/invoices`: Retrieve all invoices
- GET `/api/invoices/{id}`: Retrieve an invoice by ID
- POST `/api/invoices`: Create a new invoice
- PUT `/api/invoices/{id}`: Update an existing invoice
- DELETE `/api/invoices/{id}`: Delete an invoice


## Project Structure

```plaintext
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── billing
│   │               ├── BillingApplication.java
│   │               ├── config
│   │               │   └── SwaggerConfig.java
│   │               ├── controller
│   │               │   └── InvoiceController.java
│   │               ├── exception
│   │               │   ├── CustomExceptionHandler.java
│   │               │   └── ResourceNotFoundException.java
│   │               ├── model
│   │               │   ├── Invoice.java
│   │               │   └── InvoiceItem.java
│   │               ├── repository
│   │               │   └── InvoiceRepository.java
│   │               └── service
│   │                   ├── InvoiceService.java
│   │                   └── InvoiceServiceImpl.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── example
                └── billing
                    └── BillingApplicationTests.java
```

## Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Swagger/OpenAPI
- Maven

## Contribution

If you would like to contribute to this project, please:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Cristian Fierro - [ccamilofierro@gmail.com](mailto:ccamilofierro@email.com) - [https://github.com/ccamilofierro](https://github.com/ccamilofierro)

Project Link: [https://github.com/your-username/billing-microservice](https://github.com/java-ccamilofierro/Billing)
