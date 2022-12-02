package com.wolin.school.model.grade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Grade {
    
    @Id
    @SequenceGenerator(
        name = "grade_id_sequence",
        sequenceName = "grade_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "grade_id_sequence"
    )
    private Long gid;
    private Float value;
    private int wage;

    public Grade(GradeRequest gradeRequest) {
        this.value = gradeRequest.getValue();
        this.wage = gradeRequest.getWage();
    }
    
}
