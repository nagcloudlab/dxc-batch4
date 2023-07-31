package com.example.springwithredis;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.*;
import org.springframework.data.redis.connection.lettuce.*;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

@Data
@SpringBootApplication
@RestController
public class SpringWithRedisApplication {


    @Bean
    public RedisTemplate<String, Integer> redisTemplate() {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }


    @GetMapping("/api/greet")
    public String greet() {
        Integer greetCount = redisTemplate().opsForValue().get("greet:count");
        if (greetCount == null) {
            greetCount = 1;
        } else {
            greetCount++;
        }
        redisTemplate().opsForValue().set("greet:count", greetCount);
        return "Hello - " + greetCount;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringWithRedisApplication.class, args);
    }

}
