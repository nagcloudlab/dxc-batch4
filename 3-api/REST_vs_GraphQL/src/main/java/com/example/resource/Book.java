package com.example.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Book {
    private int id;
    private String title;
    private double price;
    private String description;
    @JsonIgnore
    private List<Author> authors=List.of();
}
