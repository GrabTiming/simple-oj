package com.Lnn.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChoiceQuestionDTO extends QuestionDTO{

    @ApiModelProperty(name = "选项数量")
    private Integer fieldCount;

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    private String field6;
}
