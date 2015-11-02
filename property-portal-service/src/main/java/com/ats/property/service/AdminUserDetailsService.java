package com.ats.property.service;

import com.ats.property.dao.IPropertyAdminDAO;
import com.ats.property.model.AdminLogin;
import com.ats.property.model.PropertyUser;
import com.ats.property.spring.UserInformation;
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


import javax.transaction.Transactional;
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
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AdminLogin adminlogin = adminDAO.getAdminUser(userName);

        PropertyUser propertyUser = adminDAO.getPropertyUser(userName);
        List<GrantedAuthority> authorityList = null;
        UserInformation user = null;

        if (adminlogin == null && propertyUser == null) {
            throw new UsernameNotFoundException("Username Not Found!");
        }
        if(propertyUser != null) {
                authorityList = new ArrayList<GrantedAuthority>() {{
                String role = "ROLE_USER";
                add(new SimpleGrantedAuthority(role));
            }};
            boolean isMailVerified = false;
            if(propertyUser.getIsMailVerified() != null && propertyUser.getIsMailVerified().equals("Y")){
                isMailVerified = true;
            }
            user = new UserInformation(propertyUser.getEmailId(), propertyUser.getPasswrd(), isMailVerified, true, true, true, authorityList);
            user.setFirstName(propertyUser.getFirstName());
            user.setUserId(propertyUser.getId());
        } else if(adminlogin != null) {
                authorityList = new ArrayList<GrantedAuthority>() {{
                String role = "ROLE_ADMIN";
                add(new SimpleGrantedAuthority(role));
            }};
            user = new UserInformation(adminlogin.getUserName(), adminlogin.getPassword(), true, true, true, true, authorityList);
            user.setFirstName(adminlogin.getFirstName());
            user.setUserId(adminlogin.getId());
        }
        return user;
    }
}
