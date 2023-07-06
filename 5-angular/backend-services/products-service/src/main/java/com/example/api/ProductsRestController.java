package com.example.api;

import com.example.model.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProductsRestController {

    @GetMapping("/api/products")
    public ResponseEntity<?> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product 1", 100.00, "INR", "https://via.placeholder.com/150x150", LocalDateTime.now().toString(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fug"));
        products.add(new Product(2, "Product 2", 200.00, "INR", "https://via.placeholder.com/150x150", LocalDateTime.now().toString(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullam"));
        products.add(new Product(3, "Product 3", 300.00, "INR", "https://via.placeholder.com/150x150", LocalDateTime.now().toString(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation"));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
