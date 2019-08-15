package com.education.practice.dao;

import com.education.practice.pojo.PracticeCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PracticeCourseDao extends JpaRepository<PracticeCourse, Integer>, JpaSpecificationExecutor<PracticeCourse> {

    /*@Query(value = "SELECT a.practiceid,a.describe,a.image,a.price,a.attcount,b.practiceid,b.title,b.content,b.stageDesc FROM practicecourse a,practicecoursedesc b WHERE a.practiceid=?1 AND b.practiceid=?1",nativeQuery = true)
    Page<PracticeCourse> findByPracticeid(Integer practiceid, PageRequest pageable);*/
}
