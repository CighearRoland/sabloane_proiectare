package ro.uvt.observer;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.models.Book;

public class SseObserver implements Observer {
    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(SseEmitter.event()
                    .name("message")
                    .data(book, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            System.err.println("Eroare la trimiterea SSE: " + e.getMessage());
            emitter.completeWithError(e);
        }
    }
}