package com.wolin.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolin.school.model.grade.Grade;
import com.wolin.school.model.grade.GradeRequest;
import com.wolin.school.service.GradeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/grades")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping()
    public List<Grade> getGrades() {
        return gradeService.getGrades();
    }

    @PostMapping()
    public Grade postMethodName(@RequestBody GradeRequest gradeRequest) {
        return gradeService.addGrade(gradeRequest);
    }
    
}
