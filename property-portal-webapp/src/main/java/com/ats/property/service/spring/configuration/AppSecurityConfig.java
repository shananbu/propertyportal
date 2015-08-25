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
/**
 * The AppSecurityConfig.
 *
 * @author anbarasan.s
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationProvider")
    AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/admindashboard")
                .usernameParameter("username")
                .passwordParameter("password")
            .and()
                .authorizeRequests()
                .antMatchers("/admindashboard").hasAuthority("ROLE_ADMIN")
                .antMatchers("/", "/userRegistration", "/registerUser", "/userLogin", "/postProperty", "/advertiseWithUs",
                        "/searchViewPage", "/propertyAlertRegisteration", "/projectOverview", "/emiCalculator",
                        "/admin", "/authenticateAdmin", "/login", "/activateAccount", "/rest/v1/admin/modules/get/stateByCityId").permitAll()

                .anyRequest().authenticated()
            .and()
                .logout().logoutSuccessUrl("/adminLogout")
            .and()
                .exceptionHandling().accessDeniedPage("/403");

    }

    @Override
    public void configure(WebSecurity builder) throws Exception {
        builder
                .ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
