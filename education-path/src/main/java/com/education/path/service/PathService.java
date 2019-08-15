package com.education.path.service;

import com.education.path.pojo.Path;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PathService {
    Page<Path> findAll(int page, int size);

    List<Path> findAllOrderByLevelAndLearncount(int page,int size);

    List<Path> findHotPath(int page,int size);
}
