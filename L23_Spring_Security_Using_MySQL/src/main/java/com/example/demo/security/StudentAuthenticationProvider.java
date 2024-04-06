package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@Component
public class StudentAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private StudentRepo repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		System.out.println("in authenticate");
		
		Student s = repository.findByUsername(username);
		
		if(s==null) {
			throw new BadCredentialsException("Student Details Not Found");
		}
		
		if(encoder.matches(password, s.getPassword())) {
			
			System.out.println("Roles:"+getStudentRole(s.getRole()));
			
			return new UsernamePasswordAuthenticationToken(username, password, getStudentRole(s.getRole()));
		}else {
			throw new BadCredentialsException("In correct password.");
		}
		
		
	}

	private List<GrantedAuthority> getStudentRole(String studentRoles){
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		
		String [] roles = studentRoles.split(",");
		
		for (int i = 0; i < roles.length; i++) {
			grantedAuthorityList.add(new SimpleGrantedAuthority(roles[i].replaceAll("\\s+", "")));
		}
		
		return grantedAuthorityList;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

}
