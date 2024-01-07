package interface_example;

public interface Perimeter {
	
	public void peri();
	
	default void test() {
		System.out.println("Test Perimeter Called");
	}
	

}
