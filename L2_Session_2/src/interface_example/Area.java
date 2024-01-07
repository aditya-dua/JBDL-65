package interface_example;

public interface Area {
	
	float pi = 3.14f;
	public void area();
	
	static void displayArea() {
		System.out.println("Area display called");
	}
	
	default void test() {
		System.out.println("Test Called");
	}
	
	
	

}
