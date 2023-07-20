package com.example.entity;

import lombok.*;
import org.bson.types.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;
    private String name;
}
