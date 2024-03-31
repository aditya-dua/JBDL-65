package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails user = User.withUsername("spring").password(encoder.encode("spring")).roles("USER").build();
	
		UserDetails user2 = User.withUsername("admin").password(encoder.encode("spring")).roles("ADMIN").build();
		
		
		UserDetails[] userArr = {user,user2};
		
		return new InMemoryUserDetailsManager(userArr);
	}
	
	
	  @Bean public SecurityFilterChain filterChain(HttpSecurity http ) throws
	  Exception{
	  
	  http.authorizeHttpRequests()
	  .requestMatchers("/admin").hasRole("ADMIN")
	  .requestMatchers("/user").hasAnyRole("USER","ADMIN")
	  .requestMatchers("/home").permitAll() 
	  
	  .and() .formLogin() .and().httpBasic();
	  
	  return http.build();
	  
	  }
		/*
		 * 
		 * @Bean public SecurityFilterChain filterChain(HttpSecurity http ) throws
		 * Exception{
		 * 
		 * http.authorizeHttpRequests() .requestMatchers("/user").hasRole("USER")
		 * .requestMatchers("/admin").hasAnyRole("ADMIN","USER")
		 * .requestMatchers("/home").permitAll() .and() .formLogin() .and().httpBasic();
		 * 
		 * return http.build();
		 * 
		 * }
		 */
	
}
