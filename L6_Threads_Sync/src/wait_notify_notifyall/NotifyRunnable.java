package wait_notify_notifyall;

public class NotifyRunnable implements Runnable{

	private Message msg;
	
	public NotifyRunnable(Message msg) {
		super();
		this.msg = msg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		System.out.println(name+" Thread started.");
		
		try {
			Thread.sleep(2000);
			synchronized (msg) {
				msg.setMsg(name+"Notify Will be called.");
				
				//msg.notify();
				msg.notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
