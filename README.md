# Student Management System

A Full Stack Web Application developed using **Spring Boot, REST API, PostgreSQL, HTML, CSS, and JavaScript**.

## Features

* User Login & Logout authentication
* Add Student
* View Students
* Update Student
* Delete Student
* Live Search functionality
* Responsive UI

## Technologies Used

**Backend**

* Spring Boot
* Spring Data JPA (Hibernate)
* REST API
* PostgreSQL Database

**Frontend**

* HTML
* CSS (Glassmorphism UI)
* Bootstrap
* JavaScript (Fetch API, DOM Manipulation)

## How to Run the Project

1. Clone the repository:

```
git clone https://github.com/maithili-bit/student-management-system.git
```

2. Open the project in STS / Eclipse / IntelliJ

3. Configure database in:

```
src/main/resources/application.properties
```

Update:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
```

4. Run:

```
StudentappApplication.java
```

5. Open browser:

```
http://localhost:8080
```

Login Credentials:

```
username: admin
password: 1234
```

## Project Architecture

Frontend (Browser) → REST Controller → Service Layer → Repository → PostgreSQL Database

---

Developed by **Maithili Telang**

