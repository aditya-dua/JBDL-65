package joins;

public class ThreadJoinMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadJoinDemo t1 = new ThreadJoinDemo();
		ThreadJoinDemo t2 = new ThreadJoinDemo();
		ThreadJoinDemo t3 = new ThreadJoinDemo();
		
		t1.start();
		try {
			System.out.println("Thread Name"+Thread.currentThread().getName());
			
			t1.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		try {
			System.out.println("Thread Name"+Thread.currentThread().getName());
			
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t3.start();
		
	}

}
