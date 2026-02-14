🏥 Hospital Management System

A full-stack Hospital Management System built using Spring Boot that helps manage patients, doctors, appointments, insurance, and hospital administration efficiently.
This project is designed to simplify hospital workflows and provide a scalable backend for healthcare applications.

📌 Project Overview

The Hospital Management System with AI-Integration is a backend application that enables hospitals to digitally manage their operations such as:

Patient registration and management

Doctor management

Appointment scheduling

Insurance management

Department management

Chatbot support for queries

This system follows a layered architecture using Controllers, Services, Repositories, DTOs, and Entities.

🚀 Features

✅ Patient Management
✅ Doctor Management
✅ Appointment Booking System
✅ Insurance Management
✅ Department Handling
✅ Chatbot Integration
✅ REST API Architecture
✅ DTO-Based Data Transfer
✅ Maven Project Structure

🛠️ Tech Stack
Technology	Usage
Java	Core Programming Language
Spring Boot	Backend Framework
Spring Data JPA	Database Operations
Maven	Dependency Management
REST APIs	Communication Layer
MySQL / H2 (Configurable)	Database
Lombok 	Boilerplate Reduction
📂 Project Structure
HospitalManagementSystem
│
├── Controller        → Handles API Requests
├── Service           → Business Logic
├── Repository        → Database Layer
├── Entity            → Database Tables
├── DTO               → Request/Response Models
├── Config            → Application Configuration
└── Resources         → Properties & Static Files

⚙️ Installation & Setup
1️⃣ Clone Repository
git clone https://github.com/Priyanshu0420/HMS_Ai_Chatbot.git
cd HospitalManagementSystem

2️⃣ Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Run Application

Using Maven Wrapper:

./mvnw spring-boot:run


OR

mvn spring-boot:run

📡 API Modules
👨‍⚕️ Doctor APIs

Add Doctor

View Doctor

Update Doctor

Delete Doctor

🧑‍🤝‍🧑 Patient APIs

Register Patient

View Patient Details

Update Patient Info

📅 Appointment APIs

Book Appointment

View Appointments

Cancel Appointment

🏢 Admin / Manager APIs

Manage Departments

Manage Hospital Data

🤖 Chatbot APIs

Patient Query Support

🧪 Testing

Run tests using:

mvn test

🤝 Contribution

Contributions are welcome!

Steps:

Fork the repository

Create a new branch

Commit changes

Push branch

Create Pull Request

📜 License

This project is licensed under the MIT License.

👨‍💻 Author

Priyanshu Thakur
