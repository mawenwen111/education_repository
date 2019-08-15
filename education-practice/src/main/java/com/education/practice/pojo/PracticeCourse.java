package com.education.practice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "practicecourse")
public class PracticeCourse implements Serializable {

    @Id
    private Integer practiceid;

    private Integer userid;

    private String title;

    private String describe;

    private String image;

    private Integer price;

    private Integer attcount;

    private Integer status;

    private String recommon;

    private String packcourse;

    /*private String content;

    private String stagedesc;*/

}