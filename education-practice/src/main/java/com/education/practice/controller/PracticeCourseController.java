package com.education.practice.controller;

import com.education.path.pojo.PageResult;
import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import com.education.practice.pojo.PracticeCourse;
import com.education.practice.pojo.PracticeCourseDesc;
import com.education.practice.service.PracticeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("practiceCourse")
@RestController
public class PracticeCourseController {

    @Autowired
    private PracticeCourseService courseService;

    /**
     * 查询训练营列表
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "findAll/{page}/{size}",method = RequestMethod.GET)
    public Result findAll(@PathVariable int page, @PathVariable int size){
        Page<PracticeCourse> list=this.courseService.findAll(page,size);
        PageResult<PracticeCourse> pageResult = new PageResult<>(list.getTotalPages(), list.getContent());
        return new Result(true, StatusCode.OK,"查询成功",pageResult);
    }

    /**
     * 查询详情，传一个practiceID
     * @param practiceid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "findByPracticeid/{practiceid}/{page}/{size}",method = RequestMethod.GET)
    public Result findByCondition(@PathVariable Integer practiceid,@PathVariable int page, @PathVariable int size){
        Page<PracticeCourseDesc> list=this.courseService.findByCondition(practiceid,page,size);
        PageResult<PracticeCourseDesc> pageResult = new PageResult<>(list.getTotalPages(),list.getContent());
        return new Result(true, StatusCode.OK,"查询成功",pageResult);
    }

}
