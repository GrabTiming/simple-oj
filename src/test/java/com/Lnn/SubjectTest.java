package com.Lnn;

import com.Lnn.domain.entity.Subject;
import com.Lnn.mapper.SubjectMapper;
import com.Lnn.util.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubjectTest {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private IdGenerator generator;

    @Test
    public void test_01(){

        for(int i=1;i<=10;i++){
            subjectMapper.insert(new Subject(generator.nextId(),"科目"+i,false));
        }
    }
}
