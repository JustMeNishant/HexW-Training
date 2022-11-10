package com.spring.main.model;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private int id;
	private String name;
	private double price;
	private String descrip; 
	private String category;
	public Product(int id, String name, double price, String descrip, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.descrip = descrip;
		this.category = category;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String describ) {
		this.descrip = describ;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return " ID:" + id + " |_| " + name + " |_| " + price + " |_| " + descrip + " |_| "+ category + " |_| ";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	}