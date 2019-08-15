package com.education.course.controller;

import com.education.course.pojo.Label;
import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import com.education.course.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 课程标签列表查询
     * @return
     */
    @RequestMapping(value = "/labelList",method = RequestMethod.GET)
    public Result labelList(){
        List<Label> labels=this.labelService.findAll();
        System.out.println("查询结果"+labels);
        return new Result(true, StatusCode.OK,"查询成功",labels);
    }

}
