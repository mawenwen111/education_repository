package com.education.discuss.dao;

import com.education.discuss.pojo.UserDiscuss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDiscussDao extends JpaRepository<UserDiscuss,Integer>, JpaSpecificationExecutor<UserDiscuss> {
}
