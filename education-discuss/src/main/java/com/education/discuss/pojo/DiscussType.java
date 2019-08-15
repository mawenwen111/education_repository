package com.education.discuss.pojo;

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
@Table(name = "discusstype")
public class DiscussType implements Serializable {

    @Id
    private Integer typeid;

    private String typename;

    private String insertperson;

    private Date inserttime;

}