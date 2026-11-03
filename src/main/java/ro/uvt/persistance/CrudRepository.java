package ro.uvt.persistence;

import java.util.Collection;

public interface CrudRepository<T, ID> {
    T save(T entity);
    Collection<T> findAll();
    T findById(ID id);
    void deleteById(ID id);
}