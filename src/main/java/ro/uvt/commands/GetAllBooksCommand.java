package ro.uvt.commands;

import ro.uvt.models.Book;
import ro.uvt.services.BooksService;
import java.util.Collection;

public class GetAllBooksCommand implements Command<Collection<Book>> {
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public Collection<Book> execute() {
        return booksService.getAllBooks();
    }
}