package com.mybootapp.dto;

public class StudentDto {

	private String name;
	private String email;
	private String hno;
	private String city;
	private String pincode;

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(String name, String email, String hno, String city, String pincode) {
		super();
		this.name = name;
		this.email = email;
		this.hno = hno;
		this.city = city;
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHno() {
		return hno;
	}

	public void setHno(String hno) {
		this.hno = hno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", email=" + email + ", hno=" + hno + ", city=" + city + ", pincode="
				+ pincode + "]";
	}

}
