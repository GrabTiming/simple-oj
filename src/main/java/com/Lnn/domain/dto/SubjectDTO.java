package com.Lnn.domain.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectDTO {

    private Long id;

    @ApiModelProperty(name = "科目名称")
    private String name;

}
