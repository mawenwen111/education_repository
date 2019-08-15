package com.education.discuss.service;

import com.education.discuss.pojo.Arg;
import com.education.discuss.pojo.Discuss;

import java.util.List;

public interface DiscussService {

    List<Discuss> findDiscussAll(Arg arg,int page,int size);

    Discuss findByDiscussid(Integer discussid);
}
