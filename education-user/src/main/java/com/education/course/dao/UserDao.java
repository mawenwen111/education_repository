package com.education.course.dao;

import com.education.course.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {


    //用户登录
    User findByUsernameAndPassword(String username, String password);
}
