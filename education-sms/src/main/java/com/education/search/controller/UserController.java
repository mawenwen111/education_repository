package com.education.search.controller;

import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import com.education.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/userSms")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sendSms/{handphone}",method = RequestMethod.POST)
    public Result smsMessage(@PathVariable String handphone){
        this.userService.sendSms(handphone);
        return new Result(true, StatusCode.OK,"发送成功");
    }

}
