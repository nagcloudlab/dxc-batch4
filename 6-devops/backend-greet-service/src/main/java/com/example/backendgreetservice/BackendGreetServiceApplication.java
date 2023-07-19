package com.example.backendgreetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackendGreetServiceApplication {

	@GetMapping("/api/greet")
	public String greet() {
        return "Hello DXC!";
    }

	public static void main(String[] args) {
		SpringApplication.run(BackendGreetServiceApplication.class, args);
	}

}
