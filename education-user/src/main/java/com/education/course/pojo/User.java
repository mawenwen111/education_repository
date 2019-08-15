package com.education.course.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    private Integer userid;

    @Column(name = "username")
    private String username;

    private String email;

    @Column(name = "password")
    private String password;

    private String image;

    private String handphone;

    private String content;

    private Date birthday;

    private Integer sex;

    private String address;

    private Integer level;

    private Integer status;

    private String school;

    private Integer jobid;

    private Integer testcount;

    private String studytime;

    private Integer testbean;

    private Date registertime;

}