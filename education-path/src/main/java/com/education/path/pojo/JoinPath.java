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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "join_path")
public class JoinPath implements Serializable {

    @Id
    private Integer id;

    private Integer userid;

    private Integer pathid;

    private Date jointime;

    private String insertperson;

    private Date inserttime;

}