package l14_hibernate_mapping.one2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class O2MAnnotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c= new Configuration();
		
		SessionFactory sf = c.configure("hibernate-annotation-o2o.cfg.xml").buildSessionFactory();
	
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Cart cart= new Cart();
		cart.setName("Aditya's Cart");
		
		Cart cart2= new Cart();
		cart2.setName("Sachin's Cart");
		
		Items i1 = new Items(1, "iphone15", 1, 1000, cart);
		Items i2 = new Items(2, "iphone15Pro", 2, 1500, cart);
		
		Items i3 = new Items(3, "iphone14", 1, 1000, cart2);
		Items i4 = new Items(4, "iphone14Pro", 2, 1500, cart2);
		
		
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(i1);
		itemsSet.add(i2);
		
		cart.setItems(itemsSet);
		cart.setTotal(1*1000+2*1500);
	
		Set<Items> itemsSet2 = new HashSet<Items>();
		itemsSet2.add(i3);
		itemsSet2.add(i4);
		
		cart2.setItems(itemsSet2);
		cart2.setTotal(1*1000+2*1500+1);
		
		s.save(cart);
		s.save(cart2);
		
		s.save(i1);
		s.save(i2);
		s.save(i3);
		s.save(i4);
		
		s.flush();
		tx.commit();
		s.close();
		sf.close();
		
	}

}
