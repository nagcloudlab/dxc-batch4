package com.example.repository;

import com.example.entity.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;

public interface UserRepository extends MongoRepository<User, ObjectId> {
}
