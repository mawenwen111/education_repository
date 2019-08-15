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
@Table(name = "practicecoursedesc")
public class PracticeCourseDesc implements Serializable {

    @Id
    private Integer id;

    private String title;

    private Integer price;

    private Integer attcount;

    private Integer practiceid;

    private String content;

    private String stagedesc;

}