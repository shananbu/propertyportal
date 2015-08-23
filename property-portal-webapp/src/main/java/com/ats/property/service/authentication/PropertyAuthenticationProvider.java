package com.ats.property.service.authentication;

import com.ats.property.dto.ModuleList;
import com.ats.property.service.helper.IPropertyAdminHelper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * The PropertyAuthenticationProvider.
 *
 * @author anbarasan.s
 */
public class PropertyAuthenticationProvider implements AuthenticationProvider, InitializingBean {

    @Autowired
    private IPropertyAdminHelper adminHelper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        adminHelper.authenticate(authentication.getCredentials().toString(), "", new ModuleList());
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
