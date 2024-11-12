package com.Lnn.mapper;

import com.Lnn.domain.entity.Exam;

public interface ExamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Exam row);

    int insertSelective(Exam row);

    Exam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Exam row);

    int updateByPrimaryKey(Exam row);
}