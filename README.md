# **Employee Management System (EMS)**  

A simple **Employee Management System** built with **Spring Boot, Thymeleaf, and Bootstrap**. This application allows users to **manage employees**, including adding, editing, and deleting employee records with a modern UI.  

---

## **Features**  

✅ **Employee Management** – Add, edit, and delete employees.  
✅ **Bootstrap-based UI** – Responsive and professional-looking interface.  
✅ **Dashboard** – Displays total employees and department count dynamically.  
✅ **Spring Boot & MariaDB** – Backend using Spring Boot and MariaDB for data storage.  
✅ **RESTful APIs** – Uses REST endpoints for employee operations.  
✅ **Thymeleaf** – Dynamic page rendering with Spring Boot integration.  

---

## **Tech Stack**  

- **Backend:** Spring Boot, Spring MVC, Spring Data JPA  
- **Frontend:** Thymeleaf, Bootstrap 5  
- **Database:** MariaDB (or MySQL)  
- **Build Tool:** Maven  

---

## Setup & Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/ppds07/EMS.git
cd EMS
```

### 2️⃣ Configure Database
Edit src/main/resources/application.properties to match your MariaDB/MySQL setup.

Example:
```
spring.datasource.url=jdbc:mariadb://localhost:3306/ems_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Build & Run the Project
```bash
mvn clean install
mvn spring-boot:run
```

### 4️⃣ Access the Application

Open in browser:

http://localhost:8080/employees
Dashboard: http://localhost:8080/dashboard
