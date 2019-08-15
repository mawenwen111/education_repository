package com.education.search.config;

import com.education.course.pojo.CourseES;
import com.education.search.dao.CourseDaoES;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseListener {

    @Autowired
    private CourseDaoES courseDaoES;
    /**
     * 监听到es队列后添加到ES
     * @param courseES
     */
    @RabbitHandler
    @RabbitListener(queues = "es")
    public void addES(CourseES courseES){
        //Course courseList = (Course) map.get("courseESList");
//        CourseES courseESList = (CourseES) map.get("courseESList");
        //CourseES courseES = new CourseES(courseESList.getId(), courseESList.getCoursename(), courseESList.getCoursename(), courseESList.getStatus(), courseESList.getCoursecontent());
        courseDaoES.save(courseES);
    }

}
