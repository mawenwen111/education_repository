package com.education.freemarker.config;

import com.education.course.pojo.Course;
import com.education.util.FreeMarkerUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FreeMarkerListener {

    @Autowired
    private FreeMarkerUtil freeMarkerUtil;

    @RabbitHandler
    @RabbitListener(queues = "freeMarker")
    public void makeFreeMarker(Course course) throws Exception {
        Map<String,Object> map = new HashMap<>(1);
        map.put("courseList",course);
        freeMarkerUtil.createHtmlByMode("infopub.ftl","course.html",map);
    }

}
