package com.education.search.config;

import com.education.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {
   /* @Value("${ali.appcode}")
    private String appCode;*/

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;

    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.sms.accessKeySecret}")
    private String accessKeySecret;

    @RabbitHandler
    public void receiveSms(Map<String, String> map){
        String userphone = map.get("mobile");
        String code = map.get("code");
        System.out.println("receive:"+userphone+":"+code);
        SmsUtil.sendSms(userphone,code,sign_name,template_code,accessKeyId,accessKeySecret);
    }
}
