package wait_notify_notifyall;

public class Main {
	
	public static void main(String[] args) {
		Message msg = new Message("Hello World");
		
		WaitRunnable wait = new WaitRunnable(msg);
		new Thread(wait,"Wait Thread").start();
		
		WaitRunnable wait2 = new WaitRunnable(msg);
		new Thread(wait2,"Wait 2 Thread").start();
		
		NotifyRunnable notify = new NotifyRunnable(msg);
		new Thread(notify,"Notify Thread").start();
		
		/*
		 * NotifyRunnable notify2 = new NotifyRunnable(msg); new
		 * Thread(notify2,"Notify 2 Thread").start();
		 */
	
	}

}
