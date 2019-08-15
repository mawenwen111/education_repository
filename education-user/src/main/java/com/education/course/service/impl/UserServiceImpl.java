package com.education.course.service.impl;

import com.education.course.dao.UserDao;
import com.education.course.pojo.User;
import com.education.course.service.UserService;
import com.education.util.IdWorker;
import com.education.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private MD5Util md5Util;

    @Autowired
    private IdWorker idWorker;

   /* @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;*/


    @Override
    public User findByUsernameAndPassword(User user) {
        return this.userDao.findByUsernameAndPassword(user.getUsername(),md5Util.inputPassToFormPass(user.getPassword()).toString());
    }

    @Override
    public void userRegister(String username, String password) {
        User user = new User();
        user.setUserid((int) idWorker.nextId());
        user.setUsername(username);
        user.setPassword(md5Util.inputPassToFormPass(password).toString());
        this.userDao.save(user);
    }





    /*@Override
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
    }*/

}
