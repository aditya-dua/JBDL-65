package l9_Spring_Concepts;

public class Greeting {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("Setter Called.");
		this.message = message;
	}
	
	public void display() {
		System.out.println("Message :: "+message);
	}

}
