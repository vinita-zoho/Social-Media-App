package com.in28minutes.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.Customizer;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		// All req should be authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		http.httpBasic(Customizer.withDefaults());
		
		http.csrf().disable();
		return http.build();
	}

}
