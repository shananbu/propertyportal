package com.ats.property.service.spring.configuration;

import com.ats.property.service.PropertyAdminService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The RequestFilter.
 *
 * @author anbarasan.s
 */
public class RequestFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        ((HttpServletResponse)response).addHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        if (PropertyAdminService.getCurrentUser() != null) {
            ((HttpServletResponse)response).addHeader("isAutheticated", "true");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
