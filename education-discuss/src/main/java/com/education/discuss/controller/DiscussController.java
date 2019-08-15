package com.education.discuss.controller;


import com.education.discuss.pojo.Answer;
import com.education.discuss.pojo.Arg;
import com.education.discuss.pojo.Discuss;
import com.education.discuss.service.AnswerService;
import com.education.discuss.service.DiscussService;
import com.education.path.pojo.PageResult;
import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("discuss")
public class DiscussController {

    @Autowired
    private DiscussService discussService;
    @Autowired
    private AnswerService answerService;

    /**
     * 条件查询讨论列表
     * @param page
     * @param size
     * @param arg
     * @return
     */
    @RequestMapping(value = "findByCondition/{page}/{size}",method = RequestMethod.POST)
    public Result findByCondition(@PathVariable int page, @PathVariable int size, @RequestBody Arg arg){
        Arg arg1 = new Arg();
        //如果传条件的时候，覆盖arg原有的初始值
        arg1.setFlag1(arg.getFlag1());
        arg1.setFlag2(arg.getFlag2());
        List<Answer> answers=this.answerService.findAll();
        HashMap map = new HashMap();
        for (Answer answer : answers) {
            map.put("aid",answer.getDiscussid());
            System.out.println("hahah:"+answer.getDiscussid());
        }
        //带着条件和分页去service进行判断
        List<Discuss> list = this.discussService.findDiscussAll(arg1, page, size);
        for (Discuss discuss : list) {
            map.put("did",discuss.getDiscussid());
            System.out.println("huhuh:"+discuss.getDiscussid());
        }


        return new Result(true, StatusCode.OK,"查询成功",list);
    }


    /**
     * 回答列表查询
     * @param discussid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "findAnswer/{discussid}/{page}/{size}",method = RequestMethod.POST)
    public Result findAnswer(@PathVariable Integer discussid, @PathVariable int page, @PathVariable int size){
        //根据discussID查询评论列表
        Page<Answer> answerList=this.answerService.findByDiscuss(discussid,page,size);
        //根据discussid查询单个问题
        Discuss discusses=this.discussService.findByDiscussid(discussid);
        HashMap map = new HashMap();
        map.put("dis",discusses);
        map.put("alist",answerList);
        return new Result(true,StatusCode.OK,"查询成功",map);
    }


}
