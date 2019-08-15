package com.education.course.service.impl;

import com.education.course.dao.CourseDao;
import com.education.course.pojo.Course;
import com.education.course.pojo.CourseES;
import com.education.course.service.CourseService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<Course> findAll() {
        return this.courseDao.findAll();
    }

    @Override
    public List<Course> findByStatusAndLabelidAndLinestatus(Integer status, Integer labelid, Integer linestatus) {
        return this.courseDao.findByStatusAndLabelidAndLinestatus(status,labelid,linestatus);
    }

    /**
     * 修改课程在线状态
     * @param courseid
     */
    @Override
    public int updateLinestatus(Integer courseid) {
        int i = this.courseDao.examine(courseid);
        if(i>0){
            //修改在线状态成功后，根据courseid查询这条数据
            Course course = this.courseDao.findByCourseid(courseid);
            CourseES courseES = new CourseES();

            courseES.setStatus(course.getStatus());
            courseES.setId(course.getCourseid());
            courseES.setCoursename(course.getCoursename());
            courseES.setCoursecontent(course.getCoursecontent());
            courseES.setUserid(course.getUserid());
            courseES.setLinestatus(course.getLinestatus());
            courseES.setLabelid(course.getLabelid());
            courseES.setImage(course.getImage());
            courseES.setCreatetime(course.getCreatetime());
            courseES.setCourseuptime(course.getCourseuptime());
            courseES.setCoursefollow(course.getCoursefollow());
            courseES.setCoursedowntime(course.getCoursedowntime());
            courseES.setCourseaccess(course.getCourseaccess());

//            HashMap<String, Object> map = new HashMap<>();
//            map.put("courseList",course);
//            map.put("courseESList",courseES);
//            //查询成功后放进es队里和freeMarker队列里
//            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.convertAndSend("es", courseES);
            rabbitTemplate.convertAndSend("freeMarker",  course);
        }
        return i;
    }

    @Override
    public List<Course> findCourseAll() {
        List<Course> list = this.courseDao.findAll();
        return list;
    }
}
