package com.education.discuss;

import com.education.discuss.pojo.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testMongo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test(){

        Answer answer = new Answer(1, 1459736576, 1, "这个实验不用做是吧？");
        mongoTemplate.insert(answer);
        List<Answer> all = mongoTemplate.findAll(Answer.class);
        System.out.println(all);
    }

}
