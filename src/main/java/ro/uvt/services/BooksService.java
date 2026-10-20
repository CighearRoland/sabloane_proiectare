package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.models.Book;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Service
public class BooksService {
    private final Map<Integer, Book> books = new HashMap<>();
    private int currentId = 1;

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public Book addBook(Book book) {
        books.put(currentId, book);
        currentId++;
        return book;
    }

}