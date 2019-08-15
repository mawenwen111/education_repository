package com.education.discuss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer")
public class Answer implements Serializable {

    @Id
    private Integer answerid;

    private Integer userid;

    private Integer discussid;

    private String content;

    private Date answertime;

    public Answer(Integer answerid, Integer userid, Integer discussid, String content) {
        this.answerid = answerid;
        this.userid = userid;
        this.discussid = discussid;
        this.content = content;
    }
}