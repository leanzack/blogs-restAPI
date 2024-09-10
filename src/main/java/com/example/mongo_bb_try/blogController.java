package com.example.mongo_bb_try;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class blogController {

    @Autowired
    private blogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return new ResponseEntity<List<Blog>>(blogService.allBlogs(), HttpStatus.OK);
    }
    @GetMapping("/{blogsId}")
     ResponseEntity<Optional<Blog>> getSingleBlog(@PathVariable String blogsId) {
        return new ResponseEntity<Optional<Blog>>(blogService.findBlogId(blogsId), HttpStatus.OK);

    }





}
