package com.example;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    private int id;
    private String author;
    private int rating;
    private String body;
}
