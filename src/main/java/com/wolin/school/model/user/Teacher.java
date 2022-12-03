package com.wolin.school.model.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Teacher extends User{
    
    public Teacher() {
        super();
    }
    
    public Teacher(Long uid, String email, String passwrd, String name, String lastname) {
        super(uid, email, passwrd, name, lastname);
    }

    public Teacher(String email, String passwrd, String name, String lastname) {
        super(email, passwrd, name, lastname);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"));
    }
}
