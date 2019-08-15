package com.education.discuss.service;

import com.education.discuss.pojo.Answer;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AnswerService {

    void add(Answer answer, Integer userid);

    /*List<Answer> findAll(Integer discussid);*/

    void save(Answer answer);

    List<Answer> findAll();

    Page<Answer> findByDiscuss(Integer discussid, int page, int size);
}
