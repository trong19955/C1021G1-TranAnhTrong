package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.example.demo.configuration.CustomSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("{noop}123456").roles("DBA","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/home").access("hasRole('ROLE_USER')")
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")
                .and()
                .formLogin().successHandler(new CustomSuccessHandler())
                .usernameParameter("ssoId").passwordParameter("password")
                .and()
                .csrf()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }
}
