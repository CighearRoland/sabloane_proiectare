package ro.uvt.commands;

import ro.uvt.models.Book;
import ro.uvt.services.BooksService;

public class AddBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Book book;

    public AddBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.addBook(book);
    }
}