package l13_hibernate_introduction.one2onemappingXML;

public class Transactions {
	
	private int id;
	private double amount;
	
	private Customer customer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Transactions(int id, double amount, Customer customer) {
		super();
		this.id = id;
		this.amount = amount;
		this.customer = customer;
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transactions [id=" + id + ", amount=" + amount + ", customer=" + customer + "]";
	}
	
	
	
}
