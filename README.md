# springboot-crud-application

This is a simple CRUD REST API for a simple Employee Management System using Spring Boot 2, JPA and H2 database.

API Name | HTTP Method | Path | Status Code | Description
------------ | ------------- | ------------- | ------------- | -------------
GET Employees | GET | /api/employees | 200 (OK) | Fetch all Employee resources
POST Employee | POST | /api/employees | 201 (Created) | Create a new Employee resource
GET Employee | GET | /api/employees/{id} | 200 (OK) | Fetch one Employee resource
PUT Employee | PUT | /api/employees/{id} | 200 (OK) | Update Employee resource
DELETE Employee | DELETE | /api/employees/{id} | 204 (No Content) | Delete Employee resource
