package com.education.path.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "path")
public class Path implements Serializable {

    @Id
    private Integer pathid;

    private String pathtitle;

    private String content;

    private String pathimage;

    private Integer pathcount;

    private String learntime;

    private Integer level;

    private Integer learncount;

    private String insertperson;

    private Date inserttime;

}