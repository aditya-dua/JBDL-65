package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MapperConfig {

	@Bean
	public ObjectMapper getMapper() {
		return new ObjectMapper();
	}
}
