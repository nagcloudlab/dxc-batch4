package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.service.TransferService;

@SpringBootApplication
public class MoneyTransferSystemApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MoneyTransferSystemApplication.class, args);

		TransferService transferService = context.getBean(TransferService.class);
		transferService.transfer("1", "2", 100);

	}

}
