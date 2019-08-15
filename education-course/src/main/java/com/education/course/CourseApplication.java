package com.education.course;


import com.education.util.FreeMarkerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class,args);
    }
    @Bean
    public FreeMarkerUtil freeMarkerUtil(){

        return new FreeMarkerUtil();
    }

}
