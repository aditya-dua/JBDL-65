
public class Table implements Runnable{

	
	
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Table(int num) {
		super();
		this.num = num;
	}
	int num;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Table of "+num);
		for (int i =1;i<11;i++) {
			System.out.println(num + " X "+i+" = "+i*num);
			
		}
	}

}
