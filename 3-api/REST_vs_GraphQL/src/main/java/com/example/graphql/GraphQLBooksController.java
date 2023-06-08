package com.example.graphql;

import com.example.db.FakeDB;
import com.example.resource.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLBooksController {

    @QueryMapping
    public Iterable<Book> books(){
        return FakeDB.books.values();
    }
    @QueryMapping
    public Book bookById(@Argument("id") Integer id){
        return FakeDB.books.get(id);
    }

}
