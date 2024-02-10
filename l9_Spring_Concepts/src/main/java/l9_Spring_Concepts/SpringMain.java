package l9_Spring_Concepts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		ApplicationContext context = new
				ClassPathXmlApplicationContext("spring-config.xml");
		
		System.out.println("Context:"+context);
		
		Greeting greet = (Greeting) context.getBean("greeting");
		
		//greet.setMessage("Hello World");
		
		greet.display();
		
		Greeting greet2 = (Greeting) context.getBean("greeting2");
		
		greet2.display();
	}

}
