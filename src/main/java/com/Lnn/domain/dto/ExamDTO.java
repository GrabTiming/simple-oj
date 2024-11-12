package com.Lnn.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExamDTO {

    private Long id;

    @ApiModelProperty("科目id")
    private Long subjectId;
    @ApiModelProperty("考试名称")
    private String name;
    @ApiModelProperty("考试总分")
    private Integer totalScore;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
