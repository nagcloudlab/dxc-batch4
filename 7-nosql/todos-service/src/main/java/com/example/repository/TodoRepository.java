package com.example.repository;

import com.example.entity.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;

import java.util.*;

public interface TodoRepository extends MongoRepository<Todo, ObjectId> {

    @Query(value = "{'completed':false}")
    List<Todo> findIncompleteTodos();

}
