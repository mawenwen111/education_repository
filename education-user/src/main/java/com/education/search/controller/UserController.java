package com.education.search.controller;

import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import com.education.course.pojo.User;
import com.education.course.service.UserService;
import com.education.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value="/tes",method = RequestMethod.GET)
    public String tes(){
        return "test";
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public Result userLogin(@RequestBody User user, HttpServletResponse response){
        User u=this.userService.findByUsernameAndPassword(user);
        System.out.println("登录"+u);
        if (u != null) {
            Cookie cookieUsername = new Cookie("username",u.getUsername());
            cookieUsername.setPath("/");
            response.addCookie(cookieUsername);
            //生成token
            String token = jwtUtil.createJWT(u.getUserid().toString(), u.getUsername());
            System.out.println("token"+token);
            try {
                Cookie cookie = new Cookie( "token", token);
                //cookie.setMaxAge(60 * 60 * 24);
                cookie.setPath("/");
                response.addCookie(cookie);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Result(true, StatusCode.OK,"登录成功");
        }else{
            return new Result(false, StatusCode.LOGINERROR,"用户名或密码错误");
        }
    }

   /* *//***
     * 发送短信
     * @param handphone
     * @return
     *//*
    @RequestMapping(value = "/sendSms/{handphone}",method = RequestMethod.POST)
    public Result smsMessage(@PathVariable String handphone){
        this.userService.sendSms(handphone);
        return new Result(true,StatusCode.OK,"发送成功");
    }*/

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "userRegister",method = RequestMethod.POST)
    public Result userRegister(@RequestBody User user){
        this.userService.userRegister(user.getUsername(),user.getPassword());
        return new Result(true,StatusCode.OK,"注册成功");
    }
}
