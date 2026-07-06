package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Book;
import com.cognizant.springlearn.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// REST Controller exposing endpoints for CRUD operations on Books.
// Uses ResponseEntity to return proper HTTP status codes.

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // Dependency injected constructor
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 1. GET: Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books); // returns status 200 OK
    }

    // 2. GET: Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(book -> ResponseEntity.ok(book)) // returns status 200 OK
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // returns 404 Not Found
    }

    // 3. POST: Create a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook); // returns 201 Created
    }

    // 4. PUT: Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.findById(id)
                .map(existingBook -> {
                    bookDetails.setId(id);
                    Book updatedBook = bookService.save(bookDetails);
                    return ResponseEntity.ok(updatedBook); // returns 200 OK
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // returns 404 Not Found
    }

    // 5. DELETE: Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean isDeleted = bookService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // returns 244 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // returns 404 Not Found
        }
    }
}
