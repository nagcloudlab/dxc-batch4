package com.example.api;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Could not find todo " + id);
    }
}
