package com.spring.main.model;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private int id;
	private String title;
	private int ram;
	private int memory;
	private String display;
	private String category;
	private double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String title, int ram, int memory, String display, String category, double price) {
		super();
		this.id = id;
		this.title = title;
		this.ram = ram;
		this.memory = memory;
		this.display = display;
		this.category = category;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", ram=" + ram + ", memory=" + memory + ", display=" + display
				+ ", category=" + category + ", price=" + price + "]";
	}
	
	

}
