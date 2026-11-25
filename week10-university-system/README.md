# Week 10 Final Capstone: University Management System

Event-driven JavaFX + MySQL application separating UI producers, background database `Task` consumers, JavaFX `Property` bindings, and a `ScheduledExecutorService` heartbeat.

## Prerequisites
- JDK 17+
- Apache Maven
- MySQL Server + MySQL Workbench

## Setup & Run
1. Run `sql/university_db.sql` in MySQL Workbench to create `university_db`, `programs`, and `students`.
2. Set database credentials via environment variables (or update `DatabaseUtil.java`):
   ```powershell
   $env:UNIVERSITY_DB_USER = "root"
   $env:UNIVERSITY_DB_PASSWORD = "your_mysql_password"
   ```
3. Launch the application:
   ```powershell
   mvn clean javafx:run
   ```
