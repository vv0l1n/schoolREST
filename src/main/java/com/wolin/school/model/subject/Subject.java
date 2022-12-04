package com.wolin.school.model.subject;

import java.util.List;

import com.wolin.school.model.grade.Grade;
import com.wolin.school.model.group.Group;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Group> groups;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gid")
    private List<Grade> grades;

    

    public Subject(String name) {
        this.name = name;
    }
}
