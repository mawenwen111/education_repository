package com.education.search.dao;

import com.education.course.pojo.CourseES;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CourseDaoES extends ElasticsearchRepository<CourseES,Integer> {
    Page<CourseES> findByCoursenameOrCoursecontentLike(String coursename , String coursecontent, Pageable pageable);
}
