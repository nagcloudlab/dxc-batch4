package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService{
    @GetMapping(
        value = "/product/{productId}"
    )
    Product getProduct(@PathVariable int productId);
}