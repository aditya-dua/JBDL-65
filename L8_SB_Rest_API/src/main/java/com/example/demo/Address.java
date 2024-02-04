package com.example.demo;

public class Address {
	
	private String street;
	private String city;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
		city="Delhi";
		street="Street 1";
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
