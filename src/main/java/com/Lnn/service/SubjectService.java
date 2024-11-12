package com.Lnn.service;

import com.Lnn.domain.dto.SubjectDTO;
import com.Lnn.domain.vo.SubjectVO;

import java.util.List;

public interface SubjectService {


    boolean create(SubjectDTO subjectDTO);

    boolean update(SubjectDTO subjectDTO);

    boolean delete(SubjectDTO subjectDTO);

    List<SubjectVO> findAllSubject();
}
