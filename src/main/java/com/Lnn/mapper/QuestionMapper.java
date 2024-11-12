package com.Lnn.mapper;

import com.Lnn.domain.entity.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Question row);

    int insertSelective(Question row);

    Question selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Question row);

    int updateByPrimaryKey(Question row);
}