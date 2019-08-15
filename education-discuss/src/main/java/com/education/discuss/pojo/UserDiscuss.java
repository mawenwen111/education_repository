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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_discuss")
public class UserDiscuss implements Serializable {

    @Id
    private Integer id;

    private Integer answerid;

    private Integer discussid;

    private Integer userid;

    private String content;

    private Date udtime;

}