package com.education.discuss.dao;

import com.education.discuss.pojo.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnswerDao extends MongoRepository<Answer,Integer>/*, JpaSpecificationExecutor<Answer>*/ {

    @Query("select answerid,userid,content,answertime,discussid from Answer where discussid=?1")
    Page<Answer> findByDiscussid(Integer discussid, PageRequest pageable , Class<Answer> answerClass);

    /*@Query("SELECT answerid,userid,content,answertime,discussid FROM Answer WHERE discussid=?1")
    List<Answer> findByDiscussid(Integer discussid);*/
}
