package com.education.search.controller;

import com.education.path.pojo.Result;
import com.education.path.pojo.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CourseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result errorHandler(Exception ex){
        return new Result(false, StatusCode.ERROR,ex.getMessage());
    }
}
