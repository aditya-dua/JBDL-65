
public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadSample ts = new ThreadSample();
		ts.setDaemon(true);
		ts.start();
		
		
		ThreadSample ts1 = new ThreadSample();
		ts1.start();
		
		Table t =new Table(5);
		
		Thread t1 = new Thread(t, "Thread - Table of 5");
		t1.start();
		t1.setPriority(10);
		
		Table table1 =new Table(7);
		
		Thread t2 = new Thread(table1, "Thread - Table of 7");
		
		
		t2.start();
		
		
		for(int i=0;i<10;i++) {
			System.out.println("Main: "+i);
		}
	}

}
