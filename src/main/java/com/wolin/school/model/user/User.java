package com.wolin.school.model.user;


import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public abstract class User implements UserDetails{

    @Id
    @SequenceGenerator(
        name = "user_id_sequence",
        sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_id_sequence"
    )
    private Long uid;
    private String email;
    private String passwrd;
    private String name;
    private String lastname;

    public User(String email, String passwrd, String name, String lastname) {
        this.email = email;
        this.passwrd = passwrd;
        this.name = name;
        this.lastname = lastname;
    }


    @Override
    public String getPassword() {
        return passwrd;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
