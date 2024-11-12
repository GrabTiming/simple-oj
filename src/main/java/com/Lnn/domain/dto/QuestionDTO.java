package com.Lnn.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private Long id;

    private Long subjectId;

    @ApiModelProperty(name = "题目描述")
    private String description;

    @ApiModelProperty(name = "正确选项(或参考答案)")
    private String correctField;


}
