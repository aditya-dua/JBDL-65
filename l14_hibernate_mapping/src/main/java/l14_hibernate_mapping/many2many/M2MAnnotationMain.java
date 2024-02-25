package l14_hibernate_mapping.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class M2MAnnotationMain {

	public static void main(String[] args) {
		Configuration c= new Configuration();
		
		SessionFactory sf = c.configure("hibernate-annotation-m2m.cfg.xml").buildSessionFactory();
	
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Cart cart= new Cart();
		cart.setName("Aditya's Cart");
		
		Cart cart2= new Cart();
		cart2.setName("Aditya's Second Cart");
		
		Items i1 = new Items(1, "iphone15", 1, 1000);
		Items i2 = new Items(2, "iphone15Pro", 2, 1500);	
		Items i3 = new Items(3, "iphone14", 1, 1000);
		Items i4 = new Items(4, "iphone14Pro", 2, 1500);
		
		Set<Items> itemSet = new HashSet<Items>();
		itemSet.add(i1);
		itemSet.add(i2);
		
		cart.setItems(itemSet);
		cart.setTotal(1*1000+2*1500);
		
		Set<Items> itemSet2 = new HashSet<Items>();
		itemSet2.add(i3);
		itemSet2.add(i4);
		
		cart2.setItems(itemSet2);
		cart2.setTotal(1*1000+2*1500);

		s.save(cart);
		s.save(cart2);
		
		s.save(i1);
		s.save(i2);
		s.save(i3);
		s.save(i4);
		
		s.flush();
		tx.commit();
		sf.close();
		
		
	}
}
