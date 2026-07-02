package com.cognizant.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// This is the starting point of our Library Management app.
// Spring reads applicationContext.xml to know which beans (objects) to create.
// We then ask Spring to give us the BookService bean.

public class Application {

    public static void main(String[] args) {
        // Spring creates objects based on the XML config
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean from Spring's container
        BookService bookService = context.getBean("bookService", BookService.class);

        // Use the service
        bookService.printAllBooks();

        // Find a specific book
        Book book = bookService.findById(2L);
        System.out.println("\nFound: " + book);

        // Add a new book
        bookService.addBook(new Book(4L, "Design Patterns", "GoF"));
        System.out.println("\nAfter adding new book:");
        bookService.printAllBooks();
    }
}
