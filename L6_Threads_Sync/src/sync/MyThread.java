package sync;

public class MyThread extends Thread {

	School school;
	
	
	
	
	public MyThread(School school, String name) {
		super();
		this.school = school;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			synchronized (school) {
				school.display(this.getName());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
