package com.Lnn.controller;

import com.Lnn.constants.MessageConstant;
import com.Lnn.domain.ResponseResult;
import com.Lnn.domain.dto.ChoiceQuestionDTO;
import com.Lnn.domain.dto.QuestionDTO;
import com.Lnn.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "创建选择题")
    @PostMapping("/create/choice")
    public ResponseResult create(@RequestBody ChoiceQuestionDTO questionDTO){

        boolean success = questionService.createChoiceQuestion(questionDTO);
        return success ? ResponseResult.ok() : ResponseResult.error(MessageConstant.CREATE_ERROR);
    }

    @ApiOperation(value = "创建简答题")
    @PostMapping("/create/short-answer")
    public ResponseResult create(@RequestBody QuestionDTO questionDTO){
        boolean success = questionService.createSAQ(questionDTO);
        return success ? ResponseResult.ok() : ResponseResult.error(MessageConstant.CREATE_ERROR);
    }

    @PostMapping("/update")
    public void update(){

    }

    @DeleteMapping("/delete")
    public ResponseResult delete(@RequestParam Long questionId){
        boolean success = questionService.delete(questionId);
        return success ? ResponseResult.ok() : ResponseResult.error(MessageConstant.DELETE_ERROR);
    }

    @GetMapping("/query")
    public void query(){

    }

}
