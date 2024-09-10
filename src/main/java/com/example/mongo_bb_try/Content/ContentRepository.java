package com.example.mongo_bb_try.Content;

import com.example.mongo_bb_try.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ContentRepository extends MongoRepository<Content, ObjectId> {

}
