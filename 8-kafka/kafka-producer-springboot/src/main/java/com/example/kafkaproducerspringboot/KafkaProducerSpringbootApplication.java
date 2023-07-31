package com.example.kafkaproducerspringboot;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.*;
import org.springframework.kafka.core.*;

@SpringBootApplication
public class KafkaProducerSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerSpringbootApplication.class, args);
    }


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @EventListener(ApplicationStartedEvent.class)
    public void sendMessage() {
        kafkaTemplate.send("greetings", "en", "hello");
    }

}
