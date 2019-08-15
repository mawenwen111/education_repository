package com.education.practice.service.impl;

import com.education.practice.dao.PracticeCourseDao;
import com.education.practice.dao.PracticeCourseDescDao;
import com.education.practice.pojo.PracticeCourse;
import com.education.practice.pojo.PracticeCourseDesc;
import com.education.practice.service.PracticeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PracticeCourseServiceImpl implements PracticeCourseService {

    @Autowired
    private PracticeCourseDao courseDao;
    @Autowired
    private PracticeCourseDescDao courseDescDao;

    @Override
    public Page<PracticeCourse> findAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        return this.courseDao.findAll(pageable);
    }

    @Override
    public Page<PracticeCourseDesc> findByCondition(Integer practiceid, int page, int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        Page<PracticeCourseDesc> list=this.courseDescDao.findByPracticeid(practiceid,pageable);
        return list;
    }
}
