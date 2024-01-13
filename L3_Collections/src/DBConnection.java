

public class DBConnection {

	private static DBConnection instance;
	
	private DBConnection() {
		System.out.println("Constrcutor called");
	}
	
	public static DBConnection getInstance() {
		
		if(instance == null) {
			instance= new DBConnection();
		}
		return instance;
		
	}
	
	public static void dbConnect() {
		System.out.println("DB Connected");
	}
}
