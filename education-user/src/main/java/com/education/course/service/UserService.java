package com.education.course.service;

import com.education.course.pojo.User;


public interface UserService {
    User findByUsernameAndPassword(User user);

    void userRegister(String username, String password);




    /*void sendSms(String handphone);*/
}
