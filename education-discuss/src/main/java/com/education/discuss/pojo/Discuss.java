package com.education.discuss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discuss")
public class Discuss implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer discussid;

    private String discusstitle;

    private String content;

    private Integer userid;

    private Date discusstime;

    private Integer typeid;

    private Integer viewnumber;

    private Integer replynumber;

    private Integer status;

    private String username;

    private String image;

}