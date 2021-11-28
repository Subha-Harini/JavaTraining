package com.git.webapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration 
@EnableWebSecurity
public class Securityonfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	 
         httpSecurity.csrf().disable().httpBasic().and()
         .sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
         .authorizeRequests()
         .antMatchers("/tvshows").authenticated()
         .and();
        
    }

}
