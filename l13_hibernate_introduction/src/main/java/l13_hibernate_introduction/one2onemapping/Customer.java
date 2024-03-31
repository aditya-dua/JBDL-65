package l13_hibernate_introduction.one2onemapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="customer-one2one-annotation")
public class Customer {

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="tx_id")
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
