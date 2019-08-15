package com.education.search.service;

import com.education.course.pojo.CourseES;
import org.springframework.data.domain.Page;

public interface CourseSearchService {

    Page<CourseES> findByCoursenameLike(String keywords, int page, int size);

    void sava(CourseES course);
}
