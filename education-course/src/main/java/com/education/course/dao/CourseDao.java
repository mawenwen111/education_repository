package com.education.course.dao;

import com.education.course.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {

    List<Course> findAll();

    List<Course> findByStatusAndLabelidAndLinestatus(Integer status, Integer labelid, Integer linestatus);

    /**
     * 修改课程在线状态（改为在线）
     * @param courseid
     */
    @Modifying
    @Query("update Course set linestatus=0 where courseid=?1")
    int examine(Integer courseid);

    Course findByCourseid(Integer courseid);

    @Query("SELECT a.courseid,a.coursename,a.coursecontent,a.status,a.labelid,a.linestatus,a.courseuptime,a.coursedowntime,a.createtime,a.courseaccess,a.coursefollow,a.userid,a.image,b.labelname FROM Course a LEFT JOIN Label b on a.labelid=b.labelid")
    List<Course> findCourseAll();
}
