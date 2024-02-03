package wait_notify_notifyall;

public class WaitRunnable implements Runnable{

	private Message msg;
	
	public WaitRunnable(Message msg) {
		super();
		this.msg = msg;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println("Thread "+name+" waiting for notification: "+System.currentTimeMillis());
				
				msg.wait();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread "+name+" got the notification: "+System.currentTimeMillis());
			System.out.println("Thread "+name+" Message "+msg.getMsg());
			
		}
	}

	
}
