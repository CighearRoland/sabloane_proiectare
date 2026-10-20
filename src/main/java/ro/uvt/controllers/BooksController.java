package ro.uvt.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.models.Book;
import ro.uvt.services.BooksService;
import ro.uvt.commands.*;
import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor commandExecutor;

    public BooksController(BooksService booksService, CommandExecutor commandExecutor) {
        this.booksService = booksService;
        this.commandExecutor = commandExecutor;
    }

    @GetMapping
    public Collection<Book> getBooks() {
        Command<Collection<Book>> cmd = new GetAllBooksCommand(booksService);
        return commandExecutor.execute(cmd);
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        Command<Book> cmd = new AddBookCommand(booksService, book);
        commandExecutor.executeAsync(cmd);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cererea a fost acceptata asincron.");
    }
}