package ro.uvt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.models.Book;
import ro.uvt.services.BooksService;
import ro.uvt.observer.AllBooksSubject;
import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final AllBooksSubject allBooksSubject;

    public BooksController(BooksService booksService, AllBooksSubject allBooksSubject) {
        this.booksService = booksService;
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping
    public Collection<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        Book savedBook = booksService.addBook(book); // Salvează cartea în DB
        allBooksSubject.add(savedBook); // Notifică clienții conectați prin SSE
        return savedBook;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Book book = booksService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        return booksService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        booksService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}