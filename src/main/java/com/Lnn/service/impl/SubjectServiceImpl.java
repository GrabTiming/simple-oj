package com.Lnn.service.impl;

import com.Lnn.domain.dto.SubjectDTO;
import com.Lnn.domain.entity.Subject;
import com.Lnn.domain.vo.SubjectVO;
import com.Lnn.mapper.SubjectMapper;
import com.Lnn.service.SubjectService;
import com.Lnn.util.BeanCopyUtils;
import com.Lnn.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    IdGenerator generator;

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public boolean create(SubjectDTO subjectDTO) {
        Subject subject = BeanCopyUtils.copyBean(subjectDTO, Subject.class);
        subject.setId(generator.nextId());
        int success = subjectMapper.insert(subject);
        return success>0;
    }

    @Override
    public boolean update(SubjectDTO subjectDTO) {
        Subject subject = BeanCopyUtils.copyBean(subjectDTO, Subject.class);
        int success = subjectMapper.updateByPrimaryKey(subject);
        return success>0;
    }

    @Override
    public boolean delete(SubjectDTO subjectDTO) {
        Subject subject = BeanCopyUtils.copyBean(subjectDTO, Subject.class);
        int success = subjectMapper.deleteByPrimaryKey(subject.getId());
        return success>0;
    }

    @Override
    public List<SubjectVO> findAllSubject() {
         List<Subject> list = subjectMapper.findAll();
        List<SubjectVO> result = BeanCopyUtils.copyBeanList(list, SubjectVO.class);
        return result;
    }
}
