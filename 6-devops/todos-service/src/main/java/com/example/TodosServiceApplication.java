package com.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Data
@Document(collection = "todos")
class Todo{
	@Id
	private int id;
	private String title;
	private String completed;
}

interface TodoRepository extends MongoRepository<Todo,Integer> {}

@RestController
class TodosController{
	@Autowired
    private TodoRepository repository;
	@GetMapping("/api/todos")
	public List<Todo> findAll(){
         return repository.findAll();
    }
	@PostMapping("/api/todos")
    public Todo save(@RequestBody Todo todo){
        return repository.save(todo);
    }
}


@SpringBootApplication
public class TodosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosServiceApplication.class, args);
	}

}
