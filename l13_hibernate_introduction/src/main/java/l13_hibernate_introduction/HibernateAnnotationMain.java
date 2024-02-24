package l13_hibernate_introduction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateAnnotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Configuration c= new Configuration();
		
		SessionFactory sf = c.configure("hibernate-annotation.cfg.xml").buildSessionFactory();
	
		Session session = sf.openSession();
		EmployeeAnnotation emp = new EmployeeAnnotation(1, "ADITYA", 20);
		
		Transaction tx = session.beginTransaction();
		
		
		session.save(emp);
	
		
		session.flush();
		
		tx.commit();
		session.close();
	}

}
