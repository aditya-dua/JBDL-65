

public class DBConnection3 {

	private static DBConnection3 instance;
	
	private DBConnection3() {
		System.out.println("Constrcutor called");
	}
	
	public static DBConnection3 getInstance() {
		
		if(instance == null) {
			instance= new DBConnection3();
		}
		return instance;
		
	}
	
	public static void dbConnect() {
		System.out.println("DB Connected");
	}
}
