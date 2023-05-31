package com.example.greetingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class GreetingServiceApplication {

	@GetMapping("/greet")
	public @ResponseBody String doGreet(){
		return "Hello dxc";
	}


	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceApplication.class, args);
	}

}
