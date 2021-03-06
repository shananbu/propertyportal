package com.ats.property.spring;

import com.ats.property.model.AdminLogin;
import com.ats.property.model.PropertyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * The UserInformation.
 *
 * @author anbarasan.s
 */
public class UserInformation extends User {
    private String firstName;
    private Long userId;
    private Long userTypeId;
    private String userTypeShortName;

    public String getUserTypeShortName() {
        return userTypeShortName;
    }

    public void setUserTypeShortName(String userTypeShortName) {
        this.userTypeShortName = userTypeShortName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public UserInformation(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserInformation(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }


}
