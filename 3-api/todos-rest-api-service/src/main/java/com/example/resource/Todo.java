package com.example.resource;

import lombok.Data;

@Data
public class Todo {
    private int id;
    private String title;
    private boolean completed;
    private TodoType type;
}
