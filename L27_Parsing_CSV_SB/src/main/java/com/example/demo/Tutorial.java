package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Tutorial {
	
	@Id
	private long id;
	private String name;
	private String description;
	private boolean status;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + "]";
	}
	public Tutorial(long id, String name, String description, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
	}
	public Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}

}
