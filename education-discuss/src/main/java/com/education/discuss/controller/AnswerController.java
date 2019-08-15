package com.education.discuss.controller;

import com.education.discuss.pojo.Answer;
import com.education.discuss.service.AnswerService;
import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import com.education.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private JwtUtil jwtUtil;


    /**
     * 添加评论
     * @param answer
     * @param request
     * @return
     */
    @RequestMapping(value = "addAnswer",method = RequestMethod.POST)
    public Result addAnswer(@RequestBody Answer answer, HttpServletRequest request){

        //解析token
        Cookie[] cookies = request.getCookies();
        String value="";
        Claims claims=null;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                value = cookie.getValue();
                claims = jwtUtil.parseJWT(value);
            }
        }
        //获取到当前登录用户id
        Integer userid = Integer.valueOf(claims.getId());
        //去serviceimpl判断，执行添加评论
        this.answerService.add(answer,userid);

        return new Result(true, StatusCode.OK,"回复成功");
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Result add(@RequestBody Answer answer){
        this.answerService.save(answer);
        return new Result(true,StatusCode.OK,"添加成功");
    }

}
