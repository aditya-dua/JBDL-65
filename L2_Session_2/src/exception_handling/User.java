package exception_handling;

public class User {
	
	String name;
	int age;
	String email;
	
	public void register(String name, int age, String email) throws InvalidAgeException {
		if(age<18) {
			throw new InvalidAgeException("Age should be greater than 18, recieved"+age);
		}else {
			this.name=name;
			this.age=age;
			this.email=email;
		}
	}

}
