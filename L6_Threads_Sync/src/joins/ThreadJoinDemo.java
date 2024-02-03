package joins;

public class ThreadJoinDemo extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0;i<3;i++) {
			
			try {
				Thread.sleep(500);
				System.out.println("Thread Name"+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
			
		}
	}
}
