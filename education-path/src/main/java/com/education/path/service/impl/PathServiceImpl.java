package com.education.path.service.impl;

import com.education.path.dao.PathDao;
import com.education.path.pojo.Path;
import com.education.path.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathServiceImpl implements PathService {

    @Autowired
    private PathDao pathDao;

    @Override
    public Page<Path> findAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        return this.pathDao.findAll(pageable);
    }

    @Override
    public List<Path> findAllOrderByLevelAndLearncount(int page,int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        return this.pathDao.findAllOrderByLevelAndLearncount(pageable);
    }

    @Override
    public List<Path> findHotPath(int page,int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        return this.pathDao.findHotPath(pageable);
    }
}
