package com.example.db;

import com.example.resource.Author;
import com.example.resource.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDB {

    public static Map<Integer, Book> books = new HashMap<>();
    public static Map<Integer, Author> authors = new HashMap<>();

    static {
        Author author1=new Author(1L,"author-1","author-1@mail.com","author-1-address");
        Author author2=new Author(2L,"author-2","author-2@mail.com","author-2-address");
        Book book1=new Book(1,"book-1",100.00, "book-1 description",List.of(author1));
        Book book2=new Book(2,"book-2",200.00, "book-2 description",List.of(author1,author2));
        books.put(1,book1);
        books.put(2,book2);
        authors.put(1,author1);
        authors.put(2,author2);
    }

}
