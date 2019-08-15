package com.education.path.controller;

import com.education.path.pojo.PageResult;
import com.education.path.pojo.Path;
import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import com.education.path.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("path")
public class PathController {

    @Autowired
    private PathService pathService;

    /**
     * 查询路径所有列表
     * @return
     */
    @RequestMapping(value = "findAll/{page}/{size}",method = RequestMethod.GET)
    public Result findPathAll(@PathVariable int page, @PathVariable int size){
        Page<Path> list = this.pathService.findAll(page,size);
        System.out.println("总页数："+list.getTotalPages());
        System.out.println("当前页 ："+page);
        PageResult<Path> pageResult = new PageResult<>(list.getTotalPages(), list.getContent());
        return new Result(true, StatusCode.OK,"查询成功",pageResult);
    }

    /**
     * 根据level和learncount（热度）排序desc
     * @return
     */
    @RequestMapping(value = "findAllByCondition/{page}/{size}",method = RequestMethod.GET)
    public Result findAllPathOrderByLevel(@PathVariable int page, @PathVariable int size){
        List<Path> list= this.pathService.findAllOrderByLevelAndLearncount(page,size);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    /**
     * 查询最热度路径列表
     * @return
     */
    @RequestMapping(value = "findAllByHot/{page}/{size}",method = RequestMethod.GET)
    public Result findHotPath(@PathVariable int page, @PathVariable int size){
        List<Path> list=this.pathService.findHotPath(page,size);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

}
