# Spring REST and Spring Boot Notes

## What is REST?

REST = Representational State Transfer.
It's a way of building APIs (Application Programming Interfaces) using HTTP.

| HTTP Method | What it does         | Example                    |
|-------------|----------------------|----------------------------|
| GET         | Read data            | GET /books → get all books |
| POST        | Create new data      | POST /books → add a book   |
| PUT         | Update existing data | PUT /books/1 → update book |
| DELETE      | Delete data          | DELETE /books/1 → delete   |

## What is Spring Boot?

Spring Boot makes it easy to create Spring applications without a lot of setup.
- No need to configure XML files manually
- Embedded server (Tomcat) - just run the app
- Auto-configuration - Spring figures out settings for you

## Simple REST Controller

```java
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }
}
```

## HTTP Status Codes

| Code | Meaning              |
|------|----------------------|
| 200  | OK - success         |
| 201  | Created              |
| 400  | Bad Request          |
| 404  | Not Found            |
| 500  | Internal Server Error|
