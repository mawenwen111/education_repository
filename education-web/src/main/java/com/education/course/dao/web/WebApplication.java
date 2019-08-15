package com.education.course.dao.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by gengmeng on 2019/7/16.
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.education.feign"})
public class WebApplication {
    public static void main(String[] args){
        SpringApplication.run(WebApplication.class,args);
    }

}
