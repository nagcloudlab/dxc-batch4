package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/api/greet")
    public ResponseEntity<Greet> greet() {
        return ResponseEntity.ok(new Greet("Hello DXC"));
    }


}
