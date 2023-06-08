package com.example.rest;

import com.example.db.FakeDB;
import com.example.resource.Author;
import com.example.resource.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {

    @GetMapping
    public Iterable<Author> getAuthors() {
        return FakeDB.authors.values();
    }

    @GetMapping("/{id}")
    public Author getAuhor(@PathVariable int id) {
        return FakeDB.authors.get(id);
    }

}