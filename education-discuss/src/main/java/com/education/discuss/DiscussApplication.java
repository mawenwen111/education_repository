package com.education.discuss;

import com.education.util.IdWorker;
import com.education.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
    public class DiscussApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscussApplication.class,args);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
