package com.education.course.dao.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gengmeng on 2019/7/16.
 */
@FeignClient(value = "EDUCATION-USER",path = "/user")
public interface de {
    @RequestMapping(value = "/tes",method = RequestMethod.GET)
    public String tes();
}
