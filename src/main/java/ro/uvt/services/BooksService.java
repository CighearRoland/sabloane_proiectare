package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.models.Book;
import ro.uvt.persistence.CrudRepository;
import java.util.Collection;

@Service
public class BooksService {
    private final CrudRepository<Book, Integer> crudRepository;

    public BooksService(CrudRepository<Book, Integer> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Collection<Book> getAllBooks() {
        return crudRepository.findAll();
    }

    public Book addBook(Book book) {
        return crudRepository.save(book);
    }

    public Book getBookById(Integer id) {
        return crudRepository.findById(id);
    }

    public Book updateBook(Integer id, Book updatedBook) {
        updatedBook.setId(id); // Setăm ID-ul pentru ca JPA să facă UPDATE, nu INSERT
        return crudRepository.save(updatedBook);
    }

    public void deleteBook(Integer id) {
        crudRepository.deleteById(id);
    }
}