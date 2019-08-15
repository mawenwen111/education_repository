package com.education.course.service;

import com.education.course.pojo.Course;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    List<Course> findByStatusAndLabelidAndLinestatus(Integer status, Integer labelid, Integer linestatus);

    @Transactional
    int updateLinestatus(Integer courseid);

    List<Course> findCourseAll();
}
