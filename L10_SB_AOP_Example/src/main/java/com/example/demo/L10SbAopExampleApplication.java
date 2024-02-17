package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class L10SbAopExampleApplication {

	public static void main(String[] args) {
		//SpringApplication.run(L10SbAopExampleApplication.class, args);
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("spring-config.xml");
	
		Student s= (Student) context.getBean("student");
		s.getName();
		s.getAge();
		s.throwEx();
	}

}
