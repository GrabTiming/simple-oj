package com.Lnn.controller;

import com.Lnn.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/create")
    public void create(){

    }

    @PostMapping("/update")
    public void update(){

    }

    @DeleteMapping("/delete")
    public void delete(){

    }

    @GetMapping("/query")
    public void query(){

    }

}
