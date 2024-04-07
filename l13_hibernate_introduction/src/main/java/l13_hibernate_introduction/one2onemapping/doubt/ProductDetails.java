package l13_hibernate_introduction.one2onemapping.doubt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name ="ProductDetails")
public class ProductDetails {

	@Id
	@Column(name="id")
	private int id;
	
	private String description;
	
	
	private Product product;

	public ProductDetails(int id, String desc) {
		super();
		this.id = id;
		this.description = desc;
	}

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}
	
	
	
}
