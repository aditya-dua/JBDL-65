package exception_handling;

public class InvalidAgeException extends Exception{

	String message;

	public InvalidAgeException(String message) {
		super(message);
		//this.message = message;
	}
	
	
}
