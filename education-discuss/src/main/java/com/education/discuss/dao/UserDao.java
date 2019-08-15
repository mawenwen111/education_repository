package com.education.discuss.dao;

import com.education.discuss.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {


    @Query("select username,image from User where userid=?1")
    User findByUserid(Integer userid);
}
