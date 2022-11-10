package com.model;

public class Product {
	public int id;
	public String name;
	public double price;
	public String describ;
	@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + ", price=" + price + ", describ=" + describ + "]";
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
	public String getDescrib() {
		return describ;
	}
	public void setDescrib(String describ) {
		this.describ = describ;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
