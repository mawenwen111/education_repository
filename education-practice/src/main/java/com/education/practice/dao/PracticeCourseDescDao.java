package com.education.practice.dao;

import com.education.practice.pojo.PracticeCourseDesc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PracticeCourseDescDao extends JpaRepository<PracticeCourseDesc,Integer>, JpaSpecificationExecutor<PracticeCourseDesc> {

    @Query(value = "SELECT a.practiceid,a.image,a.price,a.attcount,b.id,b.practiceid,b.title,b.content,b.stageDesc FROM practicecourse a,practicecoursedesc b WHERE a.practiceid=?1 AND b.practiceid=?1",nativeQuery = true)
    Page<PracticeCourseDesc> findByPracticeid(Integer practiceid, PageRequest pageable);
}
