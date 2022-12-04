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
public class Admin extends User {

    @Id
    @SequenceGenerator(
        name = "admin_id_sequence",
        sequenceName = "admin_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "admin_id_sequence"
    )
    private Long aid;

    public Admin() {
        super();
    }
    
    public Admin(Long aid, String email, String passwrd, String name, String lastname) {
        super(email, passwrd, name, lastname);
        this.aid = aid;
    }

    public Admin(String email, String passwrd, String name, String lastname) {
        super(email, passwrd, name, lastname);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
