package com.education.discuss.service.impl;

import com.education.discuss.dao.AnswerDao;
import com.education.discuss.dao.UserDiscussDao;
import com.education.discuss.pojo.Answer;
import com.education.discuss.pojo.UserDiscuss;
import com.education.discuss.service.AnswerService;
import com.education.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private UserDiscussDao userDiscussDao;
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Answer answer, Integer userid) {
        UserDiscuss userDiscuss = new UserDiscuss();
        //判断该用户是直接回复问题，还是和回复人进行讨论
        if(answer.getUserid()==null){//userid=null，说明该用户直接回复楼主问题
            answer.setAnswerid((int) idWorker.nextId());
            answer.setUserid(userid);
            answer.setAnswertime(new Date());
            //向answer表，执行添加评论操作
            //this.answerDao.save(answer);
            mongoTemplate.insert(answer,"answer");//添加到mongo中
        }else{//userid！=null，说明该用户是和回复人之间的讨论
            userDiscuss.setId((int) idWorker.nextId());
            userDiscuss.setDiscussid(answer.getDiscussid());
            userDiscuss.setAnswerid(answer.getUserid());
            userDiscuss.setUserid(userid);
            userDiscuss.setContent(answer.getContent());
            userDiscuss.setUdtime(new Date());
            System.out.println("discussid："+userDiscuss.getDiscussid());
            //向user_discuss表，执行添加评论操作
            this.userDiscussDao.save(userDiscuss);
        }
    }

    @Override
    public void save(Answer answer) {
        mongoTemplate.insert(answer,"answer");
    }

    @Override
    public List<Answer> findAll() {
        return this.mongoTemplate.findAll(Answer.class);
    }

    @Override
    public Page<Answer> findByDiscuss(Integer discussid, int page, int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);
        return this.answerDao.findByDiscussid(discussid,pageable,Answer.class);
    }

    /*@Override
    public List<Answer> findAll(Integer discussid) {
        return this.answerDao.findByDiscussid(discussid);
    }*/

}
