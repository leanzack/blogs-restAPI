package com.example.mongo_bb_try.Review;


import com.example.mongo_bb_try.Blog;
import com.example.mongo_bb_try.Content.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBoy, String blogsId) {

        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
        Date releaseDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        Review review = reviewRepository.insert(new Review(reviewBoy, releaseDate));

        mongoTemplate.update(Blog.class)
                .matching(Criteria.where("blogsId").is(blogsId))
                .apply(new Update().push("review").value(review))
                .first();

        return review;

    }

}
