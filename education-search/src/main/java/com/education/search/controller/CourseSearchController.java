package com.education.search.controller;


import com.education.course.pojo.*;
import com.education.path.pojo.PageResult;
import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import com.education.search.service.CourseSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/courseSearch")
public class CourseSearchController {

    @Autowired
    private CourseSearchService courseSearchService;

    /**
     * 添加课程
     * @param course
     * @return
     */
    @RequestMapping(value = "addCourse",method = RequestMethod.POST)
    public Result addCourse(@RequestBody CourseES course){
        this.courseSearchService.sava(course);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    /**
     * 检索
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search/{keywords}/{page}/{size}",method = RequestMethod.GET)
    public Result findByCoursenameLike(@PathVariable String keywords,@PathVariable int page,@PathVariable int size){
        Page<CourseES> coursePage=courseSearchService.findByCoursenameLike(keywords,page,size);
        PageResult<CourseES> pageResult = new PageResult<CourseES>(coursePage.getTotalElements(), coursePage.getContent());
        return new Result(true, StatusCode.OK,"查询成功",pageResult);
}


    /*@RequestMapping(value = "/search/{keywords}/{page}/{size}",method = RequestMethod.GET)
    public Result findByTitleOrContentLike(@PathVariable String keywords,@PathVariable int page,@PathVariable int size){
        Page<Article> articlePage = articleSearchService.findByTitleOrContentLike(keywords, page, size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Article>(articlePage.getTotalElements(),articlePage.getContent()));
    }*/



}
