package com.example.mongo_bb_try.Content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection  = "content")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {

    @Id
    private ObjectId id;
    private String body;
    private String blogsId;
    private String author;
    private Date releaseDate;

    public Content(String blogsId) {
        this.blogsId = blogsId;
    }





    public Content(String body, Date releaseDate) {
        this.body = body;
        this.releaseDate = releaseDate;

    }

    public void setBlogsId(String blogsId) {
        this.blogsId = blogsId;
    }


}


