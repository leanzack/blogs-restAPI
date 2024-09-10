package com.example.mongo_bb_try.Content;

import com.example.mongo_bb_try.Blog;
import com.example.mongo_bb_try.Review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class ContentController {

    @Autowired
    private ContentService contentService;



    @PostMapping("/content")
    public ResponseEntity<Content> createContent(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Content>(contentService.createContent
                (payload.get("contentBody")
                ,payload.get("blogsId")), HttpStatus.CREATED);

    }



}




