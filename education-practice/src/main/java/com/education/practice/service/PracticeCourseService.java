package com.education.practice.service;

import com.education.practice.pojo.PracticeCourse;
import com.education.practice.pojo.PracticeCourseDesc;
import org.springframework.data.domain.Page;

public interface PracticeCourseService {
    Page<PracticeCourse> findAll(int page, int size);

    Page<PracticeCourseDesc> findByCondition(Integer practiceid, int page, int size);
}
