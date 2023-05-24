package com.example;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.AccountRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class MoneyTransferSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyTransferSystemApplication.class, args);
	}

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;

//	@EventListener(ApplicationStartedEvent.class)
//	public void  dbInit(){
//
//		Role adminRole=roleRepository.save(new Role("ROLE_ADMIN"));
//		Role userRole=roleRepository.save(new Role("ROLE_USER"));
//
//		User user1=new User("foo@mail.com","foo","Foo", List.of(userRole,adminRole));
//		User user2=new User("bar@mail.com","bar","Bar", List.of(userRole));
//
//		userRepository.save(user1);
//		userRepository.save(user2);
//
//	}

}
