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
	
	public Greeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Greeting(String message) {
		super();
		this.message = message;
	}
	
	public Greeting(int message) {
		super();
		System.out.println("Int based Constructor called");
	}

	public void display() {
		System.out.println("Message :: "+message);
	}

	public void init() {
		System.out.println("Init called");
	}
	
	public void killGreeting() {
		System.out.println("killGreeting called");
	}
}
