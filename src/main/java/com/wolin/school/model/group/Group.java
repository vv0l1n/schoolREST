package com.wolin.school.model.group;

import java.util.List;

import com.wolin.school.model.subject.Subject;
import com.wolin.school.model.user.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_group")
public class Group {
    
    @Id
    @SequenceGenerator(
        name = "group_id_sequence",
        sequenceName = "group_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "group_id_sequence"
    )
    private Long gid;
    private String name;
    @OneToMany(mappedBy = "sid")
    private List<Student> students;
    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private List<Subject> subjects;

    public Group(String name) {
        this.name = name;
    }
    
}
