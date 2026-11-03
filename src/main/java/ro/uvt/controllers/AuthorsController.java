package ro.uvt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.models.Author;
import ro.uvt.persistence.AuthorsRepository;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorsRepository authorsRepository;

    public AuthorsController(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorsRepository.findAll();
    }
}