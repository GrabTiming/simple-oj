package com.Lnn.controller;

import com.Lnn.constants.MessageConstant;
import com.Lnn.domain.ResponseResult;
import com.Lnn.domain.dto.SubjectDTO;
import com.Lnn.domain.vo.SubjectVO;
import com.Lnn.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @ApiOperation(value = "创建科目") //接口描述
    @PostMapping("/create")
    public ResponseResult create(@RequestBody SubjectDTO subjectDTO){
       boolean success = subjectService.create(subjectDTO);
       if(success) return ResponseResult.ok();
       return ResponseResult.error(MessageConstant.SERVER_ERROR);
    }

    @ApiOperation(value = "更新科目") //接口描述
    @PostMapping("/update")
    public ResponseResult update(@RequestBody SubjectDTO subjectDTO){
        boolean success = subjectService.update(subjectDTO);
        if(success) return ResponseResult.ok();
        return ResponseResult.error(MessageConstant.SERVER_ERROR);
    }

    @ApiOperation(value = "删除科目") //接口描述
    @DeleteMapping("/delete")
    public ResponseResult delete(@RequestBody SubjectDTO subjectDTO){
        boolean success = subjectService.delete(subjectDTO);
        if(success) return ResponseResult.ok();
        return ResponseResult.error(MessageConstant.SERVER_ERROR);
    }

    @ApiOperation(value = "查询所有科目")
    @GetMapping("/findAll")
    public ResponseResult findAllSubject(){
        List<SubjectVO> list = subjectService.findAllSubject();
        return ResponseResult.ok(null,list);

    }

}
