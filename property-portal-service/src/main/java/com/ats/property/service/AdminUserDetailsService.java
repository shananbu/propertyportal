package com.ats.property.service;

import com.ats.property.dao.IPropertyAdminDAO;
import com.ats.property.model.AdminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The AdminUserDetailsService.
 *
 * @author anbarasan.s
 */
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    private IPropertyAdminDAO adminDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AdminLogin adminlogin = adminDAO.getAdminUser(userName);

        if (adminlogin == null) {
            throw new UsernameNotFoundException("Username Not Found!");
        }
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>() {{
            String role = "ROLE_ADMIN";
            add(new SimpleGrantedAuthority(role));
        }};
        UserDetails user = new User(adminlogin.getUserName(), adminlogin.getPassword(), true, true, true, true, authorityList);

        return user;
    }
}
