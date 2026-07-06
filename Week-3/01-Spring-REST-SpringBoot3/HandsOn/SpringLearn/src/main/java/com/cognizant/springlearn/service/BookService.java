package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Service component managing business operations and in-memory list of books

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();
    private long currentId = 1;

    public BookService() {
        // Pre-populate with some data
        save(new Book(null, "Clean Architecture", "Robert C. Martin"));
        save(new Book(null, "Design Patterns", "Gang of Four"));
    }

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(currentId++);
            books.add(book);
        } else {
            // Update operation
            findById(book.getId()).ifPresent(existingBook -> {
                existingBook.setTitle(book.getTitle());
                existingBook.setAuthor(book.getAuthor());
            });
        }
        return book;
    }

    public boolean deleteById(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
