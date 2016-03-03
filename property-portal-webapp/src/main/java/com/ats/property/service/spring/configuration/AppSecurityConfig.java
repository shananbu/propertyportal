package com.ats.property.service.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

/**
 * The AppSecurityConfig.
 *
 * @author anbarasan.s
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationProvider")
    AuthenticationProvider authenticationProvider;


    @Autowired
    @Qualifier("customAuthenticationHandler")
    SimpleUrlAuthenticationSuccessHandler customAuthenticationHandler;

    @Autowired
    @Qualifier("customLogoutHandler")
    SimpleUrlLogoutSuccessHandler customLogoutHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http
                .csrf().disable()
                .formLogin()
                    .successHandler(customAuthenticationHandler)
                    .loginPage("/userLogin")
                    .failureUrl("/userLogin?error")
                    .failureUrl("/userLogin?error")
                    .usernameParameter("username")
                    .passwordParameter("password")
            .and()
                .authorizeRequests()
                .antMatchers("/admindashboard", "projectOverviewClassifieds", "clientReportView").hasAuthority("ROLE_ADMIN")
                .antMatchers("/postProperty", "/postPropertyInMicrosite", "manageAdvertisements", "manageProfile").hasAuthority("ROLE_USER")
                .antMatchers("/", "/index", "/userRegistration", "/registerUser", "/userLogin", "/advertiseWithUs",
                        "/searchViewPage", "/propertyAlertRegisteration", "/projectOverview", "/emiCalculator",
                        "/admin", "/authenticateAdmin", "/login", "/activateAccount", "/rest/v1/admin/modules/get/stateByCityId",
                        "/rest/v1/admin/modules/get/locationByCityId",
                        "/contactUs", "/feedback", "/privacyPolicy", "/termsAndConditions",
                        "/uploadFile", "/uploadFileAndUpdate", "/deleteUploadFile","/advtPostingComplete",
                        "/saveOrUpdateAdvertisement", "/genericErrorpage", "/userResponse", "/registerPropertyAlert",
                        "/rest/v1/admin/modules/get/getAdvertisement", "/rest/v1/admin/modules/create/registerUser",
                        "/rest/v1/admin/modules/get/budgetByPropertyForTypeId").permitAll()

                .anyRequest().authenticated()
            .and()
                .logout().logoutSuccessHandler(customLogoutHandler)/*.logoutSuccessUrl("/adminLogout")*/.logoutUrl("/j_spring_security_logout")
            .and()
                .exceptionHandling().accessDeniedPage("/403");

    }

    @Override
    public void configure(WebSecurity builder) throws Exception {
        builder
                .ignoring()
                .antMatchers("/appendGrid/**")
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**");

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
