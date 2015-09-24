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
@EnableGlobalMethodSecurity(prePostEnabled=true)
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
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .failureUrl("/login?error")
               /* .defaultSuccessUrl("/admindashboard")*/
                    .usernameParameter("username")
                    .passwordParameter("password")
            .and()
                .authorizeRequests()
                .antMatchers("/admindashboard").hasAuthority("ROLE_ADMIN")
                .antMatchers("/postProperty").hasAuthority("ROLE_USER")
                .antMatchers("/", "/userRegistration", "/registerUser", "/userLogin", "/postProperty", "/advertiseWithUs",
                        "/searchViewPage", "/propertyAlertRegisteration", "/projectOverview", "/emiCalculator",
                        "/admin", "/authenticateAdmin", "/login", "/activateAccount", "/rest/v1/admin/modules/get/stateByCityId",
                        "/rest/v1/admin/modules/get/locationByCityId",
                        "/contactUs", "/feedback", "/privacyPolicy", "/termsAndConditions", "/postPropertyInMicrosite",
                        "/uploadFile", "/uploadFileAndUpdate", "/deleteUploadFile","/advtPostingComplete",
                        "/saveOrUpdateAdvertisement", "/genericErrorpage", "/registerPropertyAlert").permitAll()


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
