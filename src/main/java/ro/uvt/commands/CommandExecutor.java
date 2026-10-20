package ro.uvt.commands;

import org.springframework.stereotype.Component;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CommandExecutor {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public <T> T execute(Command<T> command) {
        return command.execute();
    }

    public <T> void executeAsync(Command<T> command) {
        executor.submit(() -> {
            command.execute();
        });
    }
}