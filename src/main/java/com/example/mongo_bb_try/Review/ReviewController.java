package com.example.mongo_bb_try.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/blogs")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
    return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody")
            ,payload.get("blogsId")), HttpStatus.CREATED);
    }



}
