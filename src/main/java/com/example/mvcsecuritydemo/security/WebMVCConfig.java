package com.example.mvcsecuritydemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
@Configuration
public class WebMVCConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();




    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("kyaw")
                .password("{noop}kyaw")
                .roles("ADMIN","USER")
                .and()
                .withUser("thaw")
                .password("{noop}thaw")
                .roles("USER")
                .and()
                .withUser("Thomas")
                .password("{noop}thomas")
                .roles("USER");
    }
}
