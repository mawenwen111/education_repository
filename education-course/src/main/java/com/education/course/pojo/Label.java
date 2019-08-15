package com.education.course.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "label")
public class Label implements Serializable {

    private static final long serialVersionUID = -5951575348306898270L;
    @Id
    private Integer labelid;

    private String labelname;

    private String insertperson;

    private Date inserttime;

    public Integer getLabelid() {
        return labelid;
    }

    public void setLabelid(Integer labelid) {
        this.labelid = labelid;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname == null ? null : labelname.trim();
    }

    public String getInsertperson() {
        return insertperson;
    }

    public void setInsertperson(String insertperson) {
        this.insertperson = insertperson == null ? null : insertperson.trim();
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }
}