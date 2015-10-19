package com.ats.property.service.spring.configuration;

import com.ats.property.dao.IPropertyAdminDAO;
import com.ats.property.dao.PropertyAdminDAO;
import com.ats.property.mail.MailService;
import com.ats.property.scheduler.PropertyAlertNotificationJob;
import com.ats.property.scheduler.PropertyAlertNotificationTask;
import com.ats.property.service.AdminUserDetailsService;
import com.ats.property.service.IPropertyAdminService;
import com.ats.property.service.PropertyAdminService;
import com.ats.property.service.PropertyAdminWebService;
import com.ats.property.service.delegate.IPropertyAdminDelegate;
import com.ats.property.service.delegate.PropertyAdminDelegate;
import com.ats.property.service.exception.PropertyExceptionMapper;
import com.ats.property.service.helper.IPropertyAdminHelper;
import com.ats.property.service.helper.PropertyAdminHelper;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.message.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.text.ParseException;
import java.util.*;

/**
 * The WebAppConfiguration.
 *
 * @author anbarasan.s
 */
@Configuration
@EnableAspectJAutoProxy
public class WebAppBeanConfiguration {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean(name = "propertyMessagingService")
    @Scope(value = "singleton")
    @Lazy(value = false)
    @DependsOn("cxf")
    public JAXRSServerFactoryBean cxfServices(@Qualifier("jacksonProvider") final JacksonJsonProvider jacksonProvider,
                                              @Qualifier("propertyAdminWebService") final PropertyAdminWebService propertyAdminWebService,
                                              @Qualifier("propertyExceptionMapper") final PropertyExceptionMapper propertyExceptionMapper) {
        final JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setAddress("/");
        factoryBean.setServiceBeanObjects(propertyAdminWebService);
        List<Object> providers = new ArrayList<Object>();

        providers.add(jacksonProvider);
        providers.add(propertyExceptionMapper);
        factoryBean.setProviders(providers);
        factoryBean.create();
        return factoryBean;
    }

    @Bean(name = "jacksonProvider")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public JacksonJsonProvider jacksonProvider() {
        return new com.ats.property.service.spring.configuration.JacksonJsonProvider();
    }

    @Bean(name = "propertyAdminWebService", initMethod = "init")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public PropertyAdminWebService experienceWebServiceV1() {
        return new PropertyAdminWebService();
    }

    @Bean(name = "propertyExceptionMapper")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public PropertyExceptionMapper propertyExceptionMapper() {
        return new PropertyExceptionMapper();
    }

    @Bean(name = "propertyAdminDelegate")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public IPropertyAdminDelegate propertyAdminDelegate() {
        return new PropertyAdminDelegate();
    }

    @Bean(name = "propertyAdminHelper")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public IPropertyAdminHelper propertyAdminHelper() {
        return new PropertyAdminHelper();
    }

    @Bean(name = "propertyAdminService")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public IPropertyAdminService propertyAdminService() {
        return new PropertyAdminService();
    }

    @Bean(name = "propertyAdminDAO")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public IPropertyAdminDAO propertyAdminDAO() {
        return new PropertyAdminDAO();
    }

    @Bean(name = "userDetailsService")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public UserDetailsService userDetailsService() {
        return new AdminUserDetailsService();
    }

    @Bean(name = "authenticationProvider")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public AuthenticationProvider authenticationProvider() {
        return new PropertyAuthenticationProvider();
    }

    @Bean(name = "mailService")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public MailService mailService() {
        return new MailService();
    }

    @Bean(name = "customAuthenticationHandler")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public SimpleUrlAuthenticationSuccessHandler customAuthenticationHandler() {
        return new CustomAuthenticationHandler();
    }

    @Bean(name = "customLogoutHandler")
    @Scope(value = "singleton")
    @Lazy(value = false)
    public SimpleUrlLogoutSuccessHandler customLogoutHandler() {
        return new CustomLogoutHandler();
    }

    @Bean(name = "jobDetailBean")
    @Scope(value = "singleton")
    public JobDetailBean jobDetailBean() {
        JobDetailBean jobDetailBean = new JobDetailBean();
        jobDetailBean.setJobClass(PropertyAlertNotificationJob.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "anbu");
        jobDetailBean.setJobDataAsMap(map);
        return jobDetailBean;
    }

    @Bean(name = "cronTriggerBean")
    @Scope(value = "singleton")
    public CronTriggerBean cronTriggerBean(@Qualifier("jobDetailBean") final JobDetailBean jobDetailBean) {
        CronTriggerBean cronTriggerBean = new CronTriggerBean();
        cronTriggerBean.setJobDetail(jobDetailBean);
        try {
          //  cronTriggerBean.setCronExpression("0/5 * * * * ?");
            cronTriggerBean.setCronExpression("0 16 11 * * ?");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cronTriggerBean;
    }

    @Bean(name = "propertyAlertNotificationTask")
    @Scope(value = "singleton")
    public PropertyAlertNotificationTask propertyAlertNotificationTask() {
        return new PropertyAlertNotificationTask();
    }

    @Bean(name = "schedulerFactoryBean")
    @Scope(value = "singleton")
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("cronTriggerBean") final CronTriggerBean cronTriggerBean) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(cronTriggerBean);
        return bean;
    }
}
