package ro.uvt.persistence;

import org.springframework.stereotype.Component;
import ro.uvt.models.Book;
import java.util.Collection;

@Component
public class BooksRepositoryAdapter implements CrudRepository<Book, Integer> {
    private final BooksRepository booksRepository;

    public BooksRepositoryAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public Book save(Book entity) {
        return booksRepository.save(entity);
    }

    @Override
    public Collection<Book> findAll() {
        return booksRepository.findAll();
    }
}