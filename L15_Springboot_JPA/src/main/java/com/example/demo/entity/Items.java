package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="items-m2m-annotation")
public class Items {

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="itemId")
	private String itemId;
	@Column(name="quantity")
	private int quantity;
	@Column(name="total")
	private int total;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	

	public Items(int id, String itemId, int quantity, int total) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.quantity = quantity;
		this.total = total;
		
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
