package com.wolin.school.model.subject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Subject {
    @Id
    @SequenceGenerator(
        name = "subject_id_sequence",
        sequenceName = "subject_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "subject_id_sequence"
    )
    private int sid;
    private String name;

    public Subject(String name) {
        this.name = name;
    }
}
