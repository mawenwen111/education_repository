package com.education.search.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Data
//@Entity
//@Table(name = "course")
@Document(indexName = "search", type = "course")
@AllArgsConstructor
@NoArgsConstructor
public class CourseES  implements Serializable{

    private static final long serialVersionUID = -7913239393139568854L;
    @Id
    private Integer id;

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String coursename;

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String coursecontent;

    private Integer status;

}