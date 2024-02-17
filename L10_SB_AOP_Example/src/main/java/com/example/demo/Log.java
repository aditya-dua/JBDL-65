package com.example.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Log {
	
	/**
	   * A join point is in the web layer if the method is defined
	   * in a type in the com.xyz.someapp.web package or any sub-package
	   * under that.
	   */
	
	@Pointcut("execution (* com.example.demo.Student.*(..))")
	private void selectAll() {
		
	}	
	
	@Before("selectAll()")
	public void beforeAdvise() {
		System.out.println("Student Profile is to be accessed.");
	}
	
	@After("selectAll()")
	public void afterAdvise() {
		System.out.println("Student Profile is accessed.");
	}
	
	@AfterReturning(pointcut="selectAll()", returning="val")
	public void afterReturningAdvise(Object val) {
		System.out.println("Returning:"+val);
	}
	
	@AfterThrowing(pointcut="selectAll()", throwing ="ex")
	public void afterThrowingAdvise(IllegalArgumentException ex) {
		System.out.println("Exception Raised :"+ ex);
	}

}
