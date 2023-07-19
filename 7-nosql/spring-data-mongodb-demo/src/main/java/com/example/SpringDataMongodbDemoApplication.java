package com.example;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Document(collection = "users")
class User{
	@Id
	private ObjectId id;
	private String name;
}
@Data
class Project{
	private String name;
}
@Data
@Document(collection = "todos")
class Todo{
	@Id
    private ObjectId id;
    private String title;
	private boolean completed;
	private Project project;
	@DocumentReference(lazy = false)
	private User user;
}


@SpringBootApplication
public class SpringDataMongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongodbDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			MongoTemplate mongoTemplate
	) {
		return args -> {

			mongoTemplate.findAll(Todo.class).forEach(System.out::println);

		};
	}

}