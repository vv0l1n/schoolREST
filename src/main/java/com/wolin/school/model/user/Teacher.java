package com.wolin.school.model.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Teacher extends User{

    @Id
    @SequenceGenerator(
        name = "teacher_id_sequence",
        sequenceName = "teacher_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "teacher_id_sequence"
    )
    private Long tid;
    
    public Teacher() {
        super();
    }
    
    public Teacher(Long tid, String email, String passwrd, String name, String lastname) {
        super(email, passwrd, name, lastname);
        this.tid = tid;
    }

    public Teacher(String email, String passwrd, String name, String lastname) {
        super(email, passwrd, name, lastname);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"));
    }
}
