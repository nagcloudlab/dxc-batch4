package com.example;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@RestController
public class GreetController {

    private RestTemplate restTemplate=new RestTemplate();

    @GetMapping("/api/greet")
    public String greet() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        authentication.getAuthorities().forEach(System.out::println);
        System.out.println();
        return "Hello dxc!";
       // Greet greet=restTemplate.getForObject("http://localhost:8181/api/greet", Greet.class);
       // return greet.getMessage();
    }

}
