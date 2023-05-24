package com.example;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Data
@Table("ACCOUNTS")
class Account{
	@Id
	private String number;
	private double balance;
}

interface AccountRepository extends R2dbcRepository<Account, String> {
}

@RequiredArgsConstructor
@Controller
class AccountController {
	private final AccountRepository accountRepository;

	@GetMapping("/accounts/{number}")
	public @ResponseBody Mono<Account> getAccount(@PathVariable String number) throws InterruptedException {
		System.out.println(Thread.currentThread());
		//TimeUnit.SECONDS.sleep(1); // Simulate a DB call time
		Mono<Account> monoStream=accountRepository.findById(number);
		return monoStream.delayElement(Duration.ofSeconds(1));
	}
}


@SpringBootApplication
@EnableR2dbcRepositories
public class AccountsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsServiceApplication.class, args);
	}

}
