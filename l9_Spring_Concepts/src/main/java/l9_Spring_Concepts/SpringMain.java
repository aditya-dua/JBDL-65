package l9_Spring_Concepts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		ApplicationContext context = new
				ClassPathXmlApplicationContext("spring-config.xml");
		
		System.out.println("Context:"+context);
		
		Greeting greet = (Greeting) context.getBean("greeting");
		Greeting greet3 = (Greeting) context.getBean("greeting");
		
		
		//greet.setMessage("Hello World");
		
		greet.display();
		
		Greeting greet2 = (Greeting) context.getBean("greeting2");
		Greeting greet22 = (Greeting) context.getBean("greeting2");
		
		greet2.display();
		
		System.out.println(greet);
		System.out.println(greet2);
		System.out.println(greet3);
		System.out.println(greet22);
		
		((AbstractApplicationContext) context).registerShutdownHook();
	}

}
