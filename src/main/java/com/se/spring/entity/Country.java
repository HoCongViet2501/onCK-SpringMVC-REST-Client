package com.se.spring.entity;

import java.util.List;


public class Country {
	private int id;
	private String nameCountry;
	private List<Customer> customers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameCountry() {
		return nameCountry;
	}
	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}
	public Country(int id, String nameCountry) {
		super();
		this.id = id;
		this.nameCountry = nameCountry;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public Country() {
		super();
	}
	public Country(int id) {
		super();
		this.id = id;
	}
	
}
