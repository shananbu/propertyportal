package com.ats.property.service.spring.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * The CustomLogoutHandler.
 *
 * @author anbarasan.s
 */
public class CustomLogoutHandler extends SimpleUrlLogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String userTargetUrl = "/";
        String adminTargetUrl = "/admin";
        if(authentication != null && authentication.getAuthorities() != null) {
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            if (roles.contains("ROLE_ADMIN")) {
                getRedirectStrategy().sendRedirect(request, response, adminTargetUrl);
            } else if (roles.contains("ROLE_USER")) {
                getRedirectStrategy().sendRedirect(request, response, userTargetUrl);
            } else {
                super.onLogoutSuccess(request, response, authentication);
                return;
            }
        }
    }
}
