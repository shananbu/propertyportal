package com.ats.property.service.spring.configuration;

import com.ats.property.common.constants.PropertyUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * The CustomAuthenticationHandler.
 *
 * @author anbarasan.s
 */
public class CustomAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        SavedRequest savedRequest =
                new HttpSessionRequestCache().getRequest(request, response);

        if(PropertyUtils.isNotNull(savedRequest)) {
            getRedirectStrategy().sendRedirect(request, response, savedRequest.getRedirectUrl());
        } else {
            String userTargetUrl = "/postProperty";
            String adminTargetUrl = "/admindashboard";
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            if (roles.contains("ROLE_ADMIN")) {
                getRedirectStrategy().sendRedirect(request, response, adminTargetUrl);
            } else if (roles.contains("ROLE_USER")) {
                getRedirectStrategy().sendRedirect(request, response, userTargetUrl);
            } else {
                super.onAuthenticationSuccess(request, response, authentication);
                return;
            }
        }
    }
}