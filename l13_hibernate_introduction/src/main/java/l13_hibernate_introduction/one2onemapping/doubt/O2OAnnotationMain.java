package l13_hibernate_introduction.one2onemapping.doubt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class O2OAnnotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c= new Configuration();
		
		SessionFactory sf = c.configure("hibernate-annotation-o2o-doubt.cfg.xml").buildSessionFactory();
	
	
		Session s = sf.openSession();
		Transaction t= s.beginTransaction();
		
		Product iphone = new Product(0, "iphone");
		
		//ProductDetails pd = new ProductDetails(0, "iphone 14");
		s.save(iphone);
		
		ProductDetails pd = new ProductDetails();
		pd.setDesc("iphone 14");
		
		iphone.setDetails(pd);
		
		pd.setId(iphone.getId());
		
		s.save(pd);
		
		
		
		s.flush();
		t.commit();
		s.close();
		sf.close();

	}

}
