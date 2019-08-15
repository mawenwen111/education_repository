package com.education.search.service.impl;

import com.education.course.pojo.CourseES;
import com.education.search.dao.CourseDaoES;
import com.education.search.service.CourseSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CourseSearchServiceImpl implements CourseSearchService {

    @Autowired
    private CourseDaoES courseDaoES;

    @Override
    public Page<CourseES> findByCoursenameLike(String keywords, int page, int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        return courseDaoES.findByCoursenameOrCoursecontentLike(keywords,keywords,pageable);
    }

    @Override
    public void sava(CourseES course) {
        this.courseDaoES.save(course);
    }


    /*public Page<Article> findByTitleOrContentLike(String keywords,int page,int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords,keywords,pageRequest);
    }*/
}
