package com.main;

public class InnerDemo {
	public static void main(String[] args) {
		Customer c = new Customer(22343, "harry potter", 10000); 
		//Customer.Address address = c.new Address("101/2","401092", "mumbai", "MS", "India");
		Customer.Address address = new Customer.Address("101/2","401092", "mumbai", "MS", "India");
		c.setAddress(address);
		System.out.println(c);
	}
}


class Customer{
	private int accoutNumber; 
	private String name; 
	private double balance; 
	private Address address; 
	
	static class Address{
		private String addressLine;
		private String pincode;
		private String city; 
		private String state; 
		private String country;
		
		public Address(String addressLine, String pincode, String city, String state, String country) {
			super();
			this.addressLine = addressLine;
			this.pincode = pincode;
			this.city = city;
			this.state = state;
			this.country = country;
		}

		
		@Override
		public String toString() {
			return "Address [addressLine=" + addressLine + ", pincode=" + pincode + ", city=" + city + ", state="
					+ state + ", country=" + country + "]";
		}
		
		
	}

	
	public Customer(int accoutNumber, String name, double balance) {
		super();
		this.accoutNumber = accoutNumber;
		this.name = name;
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Customer [accoutNumber=" + accoutNumber + ", name=" + name + ", balance=" + balance + ", address="
				+ address + "]";
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	
}

/*
	address: 
		addressLine
		pincode
		city
		state
		country
*/