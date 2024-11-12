package com.Lnn.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    private Long id;

    private Long subjectId;

    private String name;

    private Integer totalScore;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;

    private Boolean isDeleted;
}