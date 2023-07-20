package com.example.mongodbreplicasetdemo;

import lombok.*;
import org.bson.types.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.concurrent.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todos")
class Todo {
    @Id
    private ObjectId id;
    private String title;
}

@SpringBootApplication
public class MongodbReplicasetDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbReplicasetDemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(
            MongoTemplate mongoTemplate
    ) {
        return args -> {

            new Thread(() -> {
                int i = 4;
                while (true) {
                    i++;
                    Todo todo = new Todo();
                    todo.setTitle("title" + i);
                    mongoTemplate.save(todo);
                }
            }).start();


            new Thread(() -> {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(mongoTemplate.findAll(Todo.class).stream().count());
                }
            }).start();


        };
    }

}
