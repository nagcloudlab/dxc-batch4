package com.example.resource;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Author {
    private Long id;
    private String name;
    private String email;
    private String address;
}
