package com.education.course.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.util.Date;

@Data
//@Entity
//@Table(name = "course")
@Document(indexName = "search", type = "course")
public class CourseES  implements Serializable{

    private static final long serialVersionUID = -4764279162898749526L;
    @Id
    private Integer id;

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String coursename;

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String coursecontent;

    private Integer status;

    private Integer labelid;

    private Integer linestatus;

    private Date courseuptime;

    private Date coursedowntime;

    private Date createtime;

    private Integer courseaccess;

    private Integer coursefollow;

    private Integer userid;

    private String image;

}