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
                int i = 1;
                while (true) {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    i++;
                    Todo todo = new Todo();
                    todo.setTitle("Pre-splitting the chunk ranges in an empty sharded collection allows clients to insert data into an already partitioned collection. In most situations a sharded cluster will create and distribute chunks automatically without user intervention. However, in a limited number of cases, MongoDB cannot create enough chunks or distribute data fast enough to support required throughput. For example:" + i);
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
