package com.cognizant.library;

import java.util.ArrayList;
import java.util.List;

// BookService handles the business logic for managing books.
// In a real Spring app, this would be annotated with @Service.
// For this demo, we're using Spring XML configuration instead.

public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {
        // Sample data - in a real app this would come from a database
        books.add(new Book(1L, "Effective Java", "Joshua Bloch"));
        books.add(new Book(2L, "Clean Code", "Robert C. Martin"));
        books.add(new Book(3L, "Head First Java", "Kathy Sierra"));
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void printAllBooks() {
        System.out.println("=== Library Books ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
