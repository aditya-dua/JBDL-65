package com.example.demo;

public interface UserService {
	User saveUser(User user);

    ResponseDto getUser(Long userId);
}
