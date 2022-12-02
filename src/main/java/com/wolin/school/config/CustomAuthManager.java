package com.wolin.school.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthManager implements AuthenticationManager{

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        authentication.getAuthorities()
        return null;
    }
    
}
