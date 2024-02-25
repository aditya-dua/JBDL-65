package l14_hibernate_mapping.hibernate_read_queries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ReadAnnotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration();

		SessionFactory sf = c.configure("hibernate-annotation-read.cfg.xml").buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Customer cx = new Customer();
		cx.setName("Aditya");
		cx.setAddress("Delhi");
		cx.setEmail("aditya@aditya.com");

		for (int i = 0; i < 100; i++) {
			cx = new Customer();
			cx.setName("Aditya " + i);
			cx.setAddress("Delhi" + i);
			cx.setEmail("aditya@aditya.com" + i);
			s.save(cx);

		}

		s.flush();
		tx.commit();

		// 5. Update on the basis of ID
		Transaction tx6 = s.beginTransaction();
		Query q5 = s.createQuery("update Customer set name =:name where id=:id");
		q5.setParameter("name", "Aditya - Updated");
		q5.setParameter("id", 4);
		int count = q5.executeUpdate();
		System.out.println("Updated Docs Count: " + count);

		tx6.commit();
		// Read Use Case:
		// 1. Read on the basis of ID

		Transaction tx2 = s.beginTransaction();
		Query q1 = s.createQuery("from Customer where id=:id");
		q1.setParameter("id", 4);
		Customer cus = (Customer) q1.uniqueResult();
		System.out.println(cus);
		tx2.commit();

		// 2. Customers from a table
		Transaction tx3 = s.beginTransaction();
		Query q2 = s.createQuery("from Customer");
		List<Customer> customerList = q2.list();

		for (Customer customer : customerList) {
			//System.out.println(customer);
		}
		tx3.commit();

		// 3. Aggregation queries
		Transaction tx4 = s.beginTransaction();
		Query q3 = s.createQuery("select sum(id) from Customer");
		// double sum = (Double) q3.uniqueResult();
		System.out.println("Sum of ID's " + q3.uniqueResult());
		tx4.commit();

		// 4. Order By queries
		Transaction tx5 = s.beginTransaction();
		Query q4 = s.createQuery("from Customer order by id desc");
		customerList = q4.list();
		for (Customer customer : customerList) {
			//System.out.println(customer);
		}

		tx5.commit();

		s.close();
		sf.close();

	}

}
