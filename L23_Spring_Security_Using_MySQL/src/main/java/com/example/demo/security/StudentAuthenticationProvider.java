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

//	@Autowired
//	private StudentRepo repository;
//	
//	@Autowired
//	private PasswordEncoder encoder;
	
	private StudentRepo repository;

	private PasswordEncoder encoder;

	public StudentAuthenticationProvider(StudentRepo repository, PasswordEncoder encoder) {
		this.encoder = encoder;
		this.repository = repository;
	}

	
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
			
			Authentication auth = new UsernamePasswordAuthenticationToken(username, password, getStudentRole(s.getRole()));
			
			System.out.println(auth);
			
			return auth;
		}else {
			System.err.println("Bad Creds.");
			throw new BadCredentialsException("In correct password.");
		}
		
		
	}

	private List<GrantedAuthority> getStudentRole(String studentRoles){
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		
		/*if(studentRoles.equals("admin")) {
			grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_READ"));
			grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_WRITE"));
		}*/
		
		
		String [] roles = studentRoles.split(",");
		
		for (int i = 0; i < roles.length; i++) {
			grantedAuthorityList.add(new SimpleGrantedAuthority(roles[i].trim()));
		}
		
		return grantedAuthorityList;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
		//return false;
	}

}
