package com.example.demo.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

	@Bean
	SimpleMailMessage getMailMessage() {
		return new SimpleMailMessage();
	}
	
	JavaMailSenderImpl getMailSender() {
		JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
		
		
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(589);
		javaMailSender.setUsername("adityaatgfg@gmail.com");
		javaMailSender.setPassword("");
		
		Properties properties = javaMailSender.getJavaMailProperties();
		properties.put("mail.smtp.starttls.enable", true);
		
		return javaMailSender;
		
	}
	
}
