package com.Lnn.service.impl;

import com.Lnn.constants.EntityConstants;
import com.Lnn.domain.dto.ChoiceQuestionDTO;
import com.Lnn.domain.dto.QuestionDTO;
import com.Lnn.domain.entity.Question;
import com.Lnn.mapper.QuestionMapper;
import com.Lnn.service.QuestionService;
import com.Lnn.util.BeanCopyUtils;
import com.Lnn.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    IdGenerator generator;

    @Override
    public boolean createChoiceQuestion(ChoiceQuestionDTO questionDTO) {

        Question question = BeanCopyUtils.copyBean(questionDTO, Question.class);
        question.setId(generator.nextId());
        question.setType(EntityConstants.QUESTION_CHOICE_TYPE);

        question.setCreateTime(LocalDateTime.now());
        question.setUpdateTime(LocalDateTime.now());
        question.setIsDeleted(false);

        int result = questionMapper.insertSelective(question);

        return result>0;
    }

    @Override
    public boolean createSAQ(QuestionDTO questionDTO) {
        Question question = BeanCopyUtils.copyBean(questionDTO, Question.class);
        question.setId(generator.nextId());
        question.setType(EntityConstants.QUESTION_SHORT_ANSWER_TYPE);
        Date now = new Date();
        question.setCreateTime(LocalDateTime.now());
        question.setUpdateTime(LocalDateTime.now());
        question.setIsDeleted(false);
        int result = questionMapper.insertSelective(question);

        return result>0;
    }

    @Override
    public boolean delete(Long questionId) {
        int result = questionMapper.deleteByPrimaryKey(questionId);
        return result>0;
    }
}
