package l9_Spring_Concepts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainDIWithRef {
	public static void main(String[] args) {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("spring-config-2.xml");
		
		
		Employee emp = (Employee) context.getBean("employeSetter");
		System.out.println(emp);
		
		Employee emp2 = (Employee) context.getBean("employeConstr");
		System.out.println(emp2);
		
		Employee emp3 = (Employee) context.getBean("employeSetter2");
		System.out.println(emp3);
		
		Employee emp4 = (Employee) context.getBean("employeSetter2");
		System.out.println(emp4);
		
		
	}

}
