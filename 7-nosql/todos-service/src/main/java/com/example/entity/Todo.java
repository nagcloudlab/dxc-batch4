package com.example.entity;

import lombok.*;
import org.bson.types.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@Document(collection = "todos")
public class Todo {
    @Id
    private ObjectId id;
    private String title;
    private boolean completed;
    private Project project;
    @DocumentReference(lazy = false)
    private User user;

}
