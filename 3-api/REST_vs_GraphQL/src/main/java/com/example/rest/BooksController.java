package com.example.rest;

import com.example.db.FakeDB;
import com.example.resource.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @GetMapping
    public Iterable<Book> getBooks() {
        return FakeDB.books.values();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return FakeDB.books.get(id);
    }

}
