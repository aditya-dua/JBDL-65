package exception_handling;

public class UserDefinedCustomExampleMain {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		
		User u = new User();
		try {
			u.register("ABC", 10, "abc@example.com");
		} catch (InvalidAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		System.out.println("Test");
		try {
			u.register("ABC", 19, "abc@example.com");
		} catch (InvalidAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
