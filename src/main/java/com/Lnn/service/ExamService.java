package com.Lnn.service;

import com.Lnn.domain.dto.ExamDTO;

public interface ExamService {
    boolean create(ExamDTO examDTO);

    boolean update(ExamDTO examDTO);

    boolean delete(Long examId);
}
