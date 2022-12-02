package com.wolin.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolin.school.model.grade.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long>{
    
}
