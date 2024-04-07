package l13_hibernate_introduction.one2onemapping.doubt;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name ="Product")
public class Product {

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	
	private ProductDetails details;

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

	public ProductDetails getDetails() {
		return details;
	}

	public void setDetails(ProductDetails details) {
		this.details = details;
	}

	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
