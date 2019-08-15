package com.education.course.service.impl;

import com.education.course.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendSms(String handphone) {
        //生成6位短信验证码
        Random random = new Random();
        int max=999999;//最大数
        int min=100000;//最小数
        int code = random.nextInt(max);//随机生成
        if(code<min){
            code=code+min;
        }
        System.out.println(handphone+"收到验证码是："+code);
        //将验证码放入redis
        redisTemplate.opsForValue().set("smscode_"+handphone, code+"" ,5, TimeUnit.MINUTES);//设置过期时间--五分钟
        //将验证码和手机号放到rabbitMQ中
        HashMap map = new HashMap();
        map.put("mobile",handphone);
        map.put("code",code+"");
        rabbitTemplate.convertAndSend("sms",map);
    }
}
