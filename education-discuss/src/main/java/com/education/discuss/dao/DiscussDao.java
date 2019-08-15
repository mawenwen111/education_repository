package com.education.discuss.dao;

import com.education.discuss.pojo.Discuss;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiscussDao extends JpaRepository<Discuss,Integer>, JpaSpecificationExecutor<Discuss> {

    //查询全部discuss列表，并且时间倒序排序
    @Query(value = "SELECT a.discussid,a.discusstitle,a.content,a.userid,a.discusstime,a.typeid,a.viewnumber,a.replynumber,a.status,b.username,b.image FROM Discuss a,User b WHERE a.userid=b.userid ORDER BY a.discusstime DESC",nativeQuery = true)
    List<Discuss> findDiscuss(PageRequest pageable);

    //根据传来的类型id和最热或最新查询
    @Query(value = "SELECT a.discussid,a.discusstitle,a.content,a.userid,a.discusstime,a.typeid,a.viewnumber,a.replynumber,a.status,b.username,b.image FROM Discuss a,User b  where a.userid=b.userid and typeid=?1 ORDER BY ?2 DESC ",nativeQuery = true)
    List<Discuss> findDiscussByCondition(@Param("flag1") Integer flag1, @Param("log") String log,PageRequest pageable);

    //根据类型id查未回复，并时间倒序排序
    @Query(value = "SELECT a.discussid,a.discusstitle,a.content,a.userid,a.discusstime,a.typeid,a.viewnumber,a.replynumber,a.status,b.username,b.image FROM Discuss a,User b  where a.userid=b.userid and typeid=?1 and replynumber=0 ORDER BY viewnumber DESC",nativeQuery = true)
    List<Discuss> findDiscussTh(@Param("flag1") Integer flag1,PageRequest pageable);

    @Query(value ="SELECT DISTINCT a.discussid,a.discusstitle,a.content,a.userid,a.discusstime,a.typeid,a.viewnumber,a.replynumber,a.status,b.username,b.image FROM Discuss a,User b,answer c WHERE a.discussid=?1 AND a.userid=b.userid  ORDER BY a.discusstime DESC",nativeQuery = true)
    Discuss findByDiscussid(Integer discussid);
}
