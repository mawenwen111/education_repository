package com.education.discuss.service.impl;

import com.education.discuss.dao.DiscussDao;
import com.education.discuss.dao.UserDao;
import com.education.discuss.pojo.Arg;
import com.education.discuss.pojo.Discuss;
import com.education.discuss.pojo.User;
import com.education.discuss.service.DiscussService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussDao discussDao;
    @Autowired
    private UserDao userDao;


    @Override
    public List<Discuss> findDiscussAll(Arg arg,int page,int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        List<Discuss> list=null;
        Integer flag2 = arg.getFlag2();
        String log="";//获取第二个状态
        //判断第二个传来的状态值，1最新，2最热，3未回复，直接赋字段值
        if(flag2==1){
            log="discusstime";
        }else if(flag2==2){
            log="viewnumber";
        }

        if(arg.getFlag1()==11 && arg.getFlag2()==11){//都=11时初始值，默认讨论区查全部并且时间倒序排序
            list = this.discussDao.findDiscuss(pageable);
        }else if (flag2==3){//当flag2=3时，查未回复并且按照时间倒序排序
            list=this.discussDao.findDiscussTh(arg.getFlag1(),pageable);
        }else{//除了以上两种情况，其他都按条件进行查询（类型id、最新或最热）
            System.out.println("要去查询了");
            list=this.discussDao.findDiscussByCondition(arg.getFlag1(),log,pageable);
        }
        return list;
    }

    @Override
    public Discuss findByDiscussid(Integer discussid) {
        return this.discussDao.findByDiscussid(discussid);
    }
}
