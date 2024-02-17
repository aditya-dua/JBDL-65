package l10_Spring_concepts2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new
				ClassPathXmlApplicationContext("spring-config-collection.xml");
		
		DICollections bean = (DICollections) context.getBean("collDI");
		
		System.out.println(bean.getNameList());
		System.out.println(bean.getCountrySet());
		System.out.println(bean.getAddressMap());
		
	}

}
