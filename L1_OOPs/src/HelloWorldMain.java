
public class HelloWorldMain {
	
	
	public static void main(String [] args) {
		
		float a=10f;
		
		System.out.println("Hello World");	
		System.out.println(main(10));
		System.out.println(main(a));
	}
	/*
	 * Overloading
	 * Static
	 * Compile Time
	 */
	public static String main(int a) {
		return "Main with Int";
	}
	
	
	public static String main(float a) {
		return "Main with Float";
	}
	

}

//JVM
// HelloWorldMain.main() -> try to call 
