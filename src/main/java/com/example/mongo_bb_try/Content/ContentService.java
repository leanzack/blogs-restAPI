package com.example.mongo_bb_try.Content;


import com.example.mongo_bb_try.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
public class ContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Content createContent(String contentBody, String blogsId) {


        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
        Date releaseDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        Content content = contentRepository.insert(new Content(contentBody, releaseDate));

        mongoTemplate.update(Blog.class)
                .matching(Criteria.where("blogsId").is(blogsId))
                .apply(new Update().push("content").value(content))

                .first();

        return content;

}


}
