package com.example.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private double price;
    private String currencyCode;
    private String image;
    private String makeDate;
    private String description;
}
