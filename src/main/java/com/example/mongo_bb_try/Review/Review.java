package com.example.mongo_bb_try.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection  = "review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private ObjectId id;
    private String body;
    @Setter
    private Date releaseDate; // Add this field



    public Review(String body, Date releaseDate) {
        this.body = body;
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
}
