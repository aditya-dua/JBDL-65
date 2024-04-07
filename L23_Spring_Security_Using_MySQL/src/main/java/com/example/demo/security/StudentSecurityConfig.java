package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class StudentSecurityConfig {

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
		.requestMatchers("/register").permitAll()
		.requestMatchers("/test").permitAll()
		.requestMatchers("/get").permitAll()
		.requestMatchers("/get1").hasAuthority("ROLE_READ")
		.requestMatchers("/student/roles").hasAuthority("ROLE_WRITE")
		
		//.requestMatchers("/get").permitAll()
		.and()
		.formLogin()
		.and()
		.httpBasic();
		return http.build();
	}
}
