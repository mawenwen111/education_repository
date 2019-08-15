package com.education.course.controller;


import com.education.course.pojo.Course;
import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import com.education.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 课程列表展示
     * @param course
     * @return
     */
    @RequestMapping(value = "courseList",method = RequestMethod.POST)
    public Result courseList(@RequestBody Course course){
        Integer status = course.getStatus();
        Integer labelid = course.getLabelid();
        Integer linestatus = course.getLinestatus();
        List<Course> cours = this.courseService.findByStatusAndLabelidAndLinestatus(status,labelid,linestatus);
        //System.out.println("查询结果："+cours);
        if(cours.size()>0){
            return new Result(true, StatusCode.OK,"查询成功", cours);
        }else{
            return new Result(false,StatusCode.ERROR,"查询失败");
        }
    }

    /**
     * 修改课程在线状态（改为在线）
     * @param courseid
     * @return
     */
    @RequestMapping(value = "/{courseid}",method = RequestMethod.PUT)
    public Result updateLineStatus(@PathVariable Integer courseid){
        System.out.println("受到的id："+courseid);
        //Integer courseid = course.getCourseid();
        int i=this.courseService.updateLinestatus(courseid);
        System.out.println("结果Wie："+i);
        return new Result(true,StatusCode.OK,"审核通过");
    }

    /**
     * 课程全部列表
     * @return
     */
    @RequestMapping(value = "/courseAll",method = RequestMethod.GET)
    public Result courseAll() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("courseList",this.courseService.findCourseAll());
        System.out.println("my"+map);
        return new Result(true,StatusCode.OK,"查询成功",map);
    }


}
