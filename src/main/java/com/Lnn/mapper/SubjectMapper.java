package com.Lnn.mapper;

import com.Lnn.domain.entity.Subject;

public interface SubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Subject row);

    int insertSelective(Subject row);

    Subject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subject row);

    int updateByPrimaryKey(Subject row);
}