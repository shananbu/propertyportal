package com.ats.property.service.spring.configuration;

import com.ats.property.service.hibernate.configuration.HibernateConfiguration;
import com.ats.property.service.servlet.PropertyPortalCXFServlet;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * The AppConfiguration.
 *
 * @author anbarasan.s
 */
public class AppInitializer implements WebApplicationInitializer  {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext  = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebAppBeanConfiguration.class, WebAppConfig.class, HibernateConfiguration.class);
        rootContext.setServletContext(container);
        rootContext.scan("com.ats.property");
        container.addListener(new ContextLoaderListener(rootContext));

        FilterRegistration.Dynamic springSecurityFilterChain = container.addFilter("requestFilter", new RequestFilter());
        springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
        springSecurityFilterChain.setAsyncSupported(true);

        ServletRegistration.Dynamic restServlet = container.addServlet("rest", new PropertyPortalCXFServlet());
        restServlet.setLoadOnStartup(1);
        restServlet.setAsyncSupported(true);
        restServlet.addMapping("/rest/*");

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
        servlet.setLoadOnStartup(2);
        servlet.addMapping("/");
       // servlet.setMultipartConfig(new MultipartConfigElement("/home/acreindia/uploadedResources/", 1024 * 1024 * 5, 1024 * 1024 * 5 * 5, 1024 * 1024));
        servlet.setMultipartConfig(new MultipartConfigElement("d:\\tmp", 1024 * 1024 * 5, 1024 * 1024 * 5 * 5, 1024 * 1024));
    }
}