
public class PrintTableMain {

	public static void main(String[] args) {
		
		Table t =new Table(5);
		
		Thread t1 = new Thread(t, "Thread - Table of 5");
		t1.start();
		//t1.run();
		System.out.println(t1.getId());
		System.out.println(t1.getName());
		
		Table table1 =new Table(7);
		
		
		Thread t2 = new Thread(table1, "Thread - Table of 7");
		
		
		t2.start();
		
		System.out.println(t2.getId());
		System.out.println(t2.getName());
		
	}
}
