package com.example.mongo_bb_try;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class blogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    public List<Blog> allBlogs() {
            return (List<Blog>) blogRepository.findAll();
    }

    public Optional<Blog> findBlogId(String blogsId) {
        return blogRepository.findBlogByBlogsId(blogsId);
    }







}
