package com.Lnn.service;

import com.Lnn.domain.dto.ChoiceQuestionDTO;
import com.Lnn.domain.dto.QuestionDTO;

public interface QuestionService {
    boolean createChoiceQuestion(ChoiceQuestionDTO questionDTO);

    boolean createSAQ(QuestionDTO questionDTO);

    boolean delete(Long questionId);
}
