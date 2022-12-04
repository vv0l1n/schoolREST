package com.wolin.school.model.grade;

import org.hibernate.annotations.ManyToAny;

import com.wolin.school.model.subject.Subject;
import com.wolin.school.model.user.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Builder.Default;

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
    @NonNull
    private Float value;
    private int wage;
    private String description;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Subject subject;

    public Grade(GradeRequest gradeRequest) {
        this.value = gradeRequest.getValue();
        this.wage = gradeRequest.getWage();
    }
    
}
