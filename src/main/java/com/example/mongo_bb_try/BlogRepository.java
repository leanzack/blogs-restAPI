package com.example.mongo_bb_try;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends MongoRepository<Blog, ObjectId> {


    Optional<Blog> findBlogByBlogsId(String blogsId);


}
