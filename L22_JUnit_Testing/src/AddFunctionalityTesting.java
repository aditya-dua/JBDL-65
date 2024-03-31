import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddFunctionalityTesting {

	static Calculator c;
	
	@BeforeClass
	public static void setup() {
		c = new Calculator();
		System.out.println("Before Class Called");
	}
	
	@Before
	public void setupBefore() {
		
		System.out.println("Before Called");
	}
	
	@Test
	public void test() {
		int sum  = c.add(10, 20);
		assertEquals(30, sum);
	}
	
	@Test
	public void diffTest() {
		int diff  = c.diff(10, 20);
		assertEquals(-10, diff);
		
	}
	
	@Test
	public void nameTest() {
		String message   = c.greet("Aditya");
		assertEquals("Hello Aditya,", message);
		
	}
	
	@After
	public void afterTest() {
		//c = null;
		System.out.println("After Called");
	}
	

}
