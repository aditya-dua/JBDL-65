package sync;

public class MainTEst {
	
	public static void main(String[] args) {
		School sch= new School("School 1");
		
		//School sch1 = new School("School 2");
		
		MyThread t1 = new MyThread(sch, "Aditya");
		
		MyThread t2 = new MyThread(sch, "Rohan");
		
		t1.start();
		t2.start();
	}

}
