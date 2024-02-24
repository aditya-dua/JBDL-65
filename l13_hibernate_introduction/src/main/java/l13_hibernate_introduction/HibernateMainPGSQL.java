package l13_hibernate_introduction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMainPGSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c= new Configuration();
		
		SessionFactory sf = c.configure("hibernate-pg.cfg.xml").buildSessionFactory();
	
		System.out.println(sf);
		
		Session s = sf.openSession();
		
		Employee e = new Employee(1000, "Aditya", 25);
		
		s.save(e);
		s.close();
		sf.close();
	}

}
