package l13_hibernate_introduction.one2onemappingXML;

public class Customer {

	
	private int id;
	
	
	private String name;
	

	private String email;
	
	private Transactions tx;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Transactions getTx() {
		return tx;
	}

	public void setTx(Transactions tx) {
		this.tx = tx;
	}

	public Customer(int id, String name, String email, Transactions tx) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.tx = tx;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
