package com.education.course.dao;

import com.education.course.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LabelDao extends JpaRepository<Label,Integer>, JpaSpecificationExecutor<Label> {
}
