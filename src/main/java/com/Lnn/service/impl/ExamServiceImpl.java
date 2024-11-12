package com.Lnn.service.impl;

import com.Lnn.domain.dto.ExamDTO;
import com.Lnn.domain.entity.Exam;
import com.Lnn.mapper.ExamMapper;
import com.Lnn.service.ExamService;
import com.Lnn.util.BeanCopyUtils;
import com.Lnn.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    IdGenerator generator;

    @Autowired
    private ExamMapper examMapper;

    @Override
    public boolean create(ExamDTO examDTO) {

        Exam exam = BeanCopyUtils.copyBean(examDTO, Exam.class);
        exam.setId(generator.nextId());

        exam.setCreateTime(LocalDateTime.now());
        exam.setUpdateTime(LocalDateTime.now());
        exam.setIsDeleted(false);

        int result = examMapper.insert(exam);

        return result>0;
    }

    @Override
    public boolean update(ExamDTO examDTO) {
        Exam exam = BeanCopyUtils.copyBean(examDTO, Exam.class);
        exam.setUpdateTime(LocalDateTime.now());
        int result = examMapper.updateByPrimaryKey(exam);

        return result>0;
    }

    @Override
    public boolean delete(Long examId) {

        int result = examMapper.deleteByPrimaryKey(examId);
        return result>0;
    }
}
