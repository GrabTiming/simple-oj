package com.Lnn.controller;

import com.Lnn.constants.MessageConstant;
import com.Lnn.domain.ResponseResult;
import com.Lnn.domain.dto.ExamDTO;
import com.Lnn.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping("/create")
    public ResponseResult create(@RequestBody ExamDTO examDTO){
        boolean success = examService.create(examDTO);
        return success ? ResponseResult.ok() : ResponseResult.error(MessageConstant.CREATE_ERROR);
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody ExamDTO examDTO){
        boolean success = examService.update(examDTO);
        return success ? ResponseResult.ok() : ResponseResult.error(MessageConstant.UPDATE_ERROR);
    }

    @DeleteMapping("/delete")
    public ResponseResult delete(@PathVariable Long examId){
        boolean success = examService.delete(examId);
        return success ? ResponseResult.ok() : ResponseResult.error(MessageConstant.DELETE_ERROR);
    }

    @GetMapping("/query")
    public ResponseResult query(){

        return null;
    }

}
