

public class Singleton {

	// Eager Init : Thread Safe
	private static Singleton instance = new Singleton();
	
	private Singleton() {
		System.out.println("Constrcutor called");
	}
	
	public static Singleton getInstance() {
		
		//Lazy Init
		if(instance == null) {
			instance= new Singleton();
		}
		return instance;
		
	}
	
	public static void dbConnect() {
		System.out.println("DB Connected");
	}
}
