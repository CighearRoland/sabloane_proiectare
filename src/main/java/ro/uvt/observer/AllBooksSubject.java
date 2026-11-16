package ro.uvt.observer;

import org.springframework.stereotype.Component;
import ro.uvt.models.Book;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject {
    // Folosim CopyOnWriteArrayList pentru a evita problemele de concurență (mai mulți clienți conectați simultan)
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }

    // Metoda apelată la crearea unei noi cărți
    public void add(Book book) {
        notifyObservers(book);
    }
}