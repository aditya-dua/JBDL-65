package l13_hibernate_introduction.one2onemapping;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tx-one2one-annotation")
public class Transactions {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="amount")
	private double amount;
	
	@OneToOne(mappedBy = "tx")
	@Cascade(value = CascadeType.ALL)
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
