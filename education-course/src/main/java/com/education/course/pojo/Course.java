package com.education.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
public class Course  implements Serializable{

    private static final long serialVersionUID = -2830058301085596398L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseid;

    private String coursename;

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