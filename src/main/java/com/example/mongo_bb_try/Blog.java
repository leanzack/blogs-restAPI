package com.example.mongo_bb_try;


import com.example.mongo_bb_try.Content.Content;
import com.example.mongo_bb_try.Review.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection  = "blogs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    private ObjectId id;
    private String blogsId;
    private String title;

    private List<String> type;

    @DocumentReference
    private List<Content> content;

    @DocumentReference
    private List<Review> review;



}
