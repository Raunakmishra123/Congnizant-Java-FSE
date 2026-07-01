# Library Management System

This is a simple Java application demonstrating the usage of **Spring Core** and **dependency injection** using XML configuration.

## Features
- Model representation of a `Book`.
- `BookService` to handle retrieving, adding, and displaying library books.
- XML-based Spring Application Context.

## Structure
- `src/main/java/com/cognizant/library/Book.java`: Standard POJO class with constructor, getters, setters, and toString.
- `src/main/java/com/cognizant/library/BookService.java`: Service class handling business logic.
- `src/main/java/com/cognizant/library/Application.java`: Main class that initializes the Spring Context and executes operations.
- `src/main/resources/applicationContext.xml`: XML configuration defining beans managed by Spring.
