

public class DBConnection2 {

	private static DBConnection2 instance;
	
	private DBConnection2() {
		System.out.println("Constrcutor called");
	}
	
	public static DBConnection2 getInstance() {
		
		if(instance == null) {
			instance= new DBConnection2();
		}
		return instance;
		
	}
	
	public static void dbConnect() {
		System.out.println("DB Connected");
	}
}
