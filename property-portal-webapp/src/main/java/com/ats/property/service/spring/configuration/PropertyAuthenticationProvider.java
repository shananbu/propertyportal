package com.ats.property.service.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


/**
 * The PropertyAuthenticationProvider.
 *
 * @author anbarasan.s
 */

public class PropertyAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    @Qualifier("userDetailsService")
    @Override
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        try {
            Authentication auth = super.authenticate(authentication);
            return auth;
        } catch (BadCredentialsException e) {
            throw e;
        } catch (LockedException e) {
            String error = "User account is locked!";
            throw new LockedException(error);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
