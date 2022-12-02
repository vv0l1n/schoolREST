package com.wolin.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolin.school.model.grade.Grade;
import com.wolin.school.model.grade.GradeRequest;
import com.wolin.school.repo.GradeRepository;

@Service
public class GradeService {
    
    @Autowired
    GradeRepository gradeRepository;

    public List<Grade> getGrades() {
        return gradeRepository.findAll();
    }

    public Grade addGrade(GradeRequest gradeRequest) {
        Grade grade = new Grade(gradeRequest);
        return gradeRepository.save(grade);
    }
}
