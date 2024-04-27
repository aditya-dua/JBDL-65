package com.example.demo.dtos;

import com.example.demo.models.User;
import com.example.demo.utils.StringConstants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest {

	
	private String name;
	private String mobile;
	private String email;
	private String password;
	
	public User to() {
		return User.builder()
				.name(name)
				.password(password)
				.email(email)
				.mobile(mobile)
				.authorities(StringConstants.USER_AUTHORITY)
				.build();
	}
	
}
