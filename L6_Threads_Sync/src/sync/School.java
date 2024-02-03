package sync;

public class School {
	
	volatile String name;
	
	public School(String name) {
		super();
		this.name = name;
	}

	public void xyz() throws InterruptedException {
		display("From School Class");
	}
	
	public void display(String threadName) throws InterruptedException {
		
		synchronized (School.class) {
			for(int i =0;i<5;i++) {
				
				System.out.println(name+" - "+i);
				Thread.sleep(500);
			}
		}
		
		synchronized (name) {
			for(int i =0;i<5;i++) {
				if(i==2) {
					name="Name updated by"+threadName;
					
				}
				System.out.println(name+" - Block"+i);
				Thread.sleep(500);
			}
		}
		
	}

}
