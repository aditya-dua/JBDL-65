package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Item(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
