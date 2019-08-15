package com.education.course.service.impl;

import com.education.course.dao.LabelDao;
import com.education.course.pojo.Label;
import com.education.course.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;

    @Override
    public List<Label> findAll() {
        return this.labelDao.findAll();
    }
}
