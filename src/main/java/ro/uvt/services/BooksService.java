package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.models.Book;
import ro.uvt.persistence.CrudRepository;
import java.util.Collection;

@Service
public class BooksService {
    private final CrudRepository<Book, Integer> crudRepository;

    // Injectăm interfața generică, iar Spring va furniza automat instanța BooksRepositoryAdapter
    public BooksService(CrudRepository<Book, Integer> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Collection<Book> getAllBooks() {
        return crudRepository.findAll();
    }

    public Book addBook(Book book) {
        return crudRepository.save(book);
    }
}