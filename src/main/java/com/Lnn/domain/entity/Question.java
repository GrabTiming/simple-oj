package com.Lnn.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Long id;

    private Long subjectId;

    private Integer type;

    private String description;

    private Integer fieldCount;

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String correctField;

    private String textField;

    private Date createTime;

    private Date updateTime;

    private Boolean isDeleted;

}