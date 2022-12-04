package com.wolin.school.model.user;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.wolin.school.model.grade.Grade;
import com.wolin.school.model.group.Group;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student extends User {

    @Id
    @SequenceGenerator(
        name = "student_id_sequence",
        sequenceName = "student_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_id_sequence"
    )
    private Long sid;
    @ManyToOne
    private Group group;
    @OneToMany(mappedBy = "gid", cascade = CascadeType.ALL)
    private List<Grade> grades;
    
    public Student() {
        super();
    }
    
    public Student(Long sid, String email, String passwrd, String name, String lastname) {
        super(email, passwrd, name, lastname);
    }

    public Student(String email, String passwrd, String name, String lastname) {
        super(email, passwrd, name, lastname);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));
    }
}
