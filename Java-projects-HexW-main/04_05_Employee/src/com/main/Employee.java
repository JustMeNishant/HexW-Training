package com.main;

public class Employee {
public int id;
public String name;
public String city;
public double salary;
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
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "employee [id=" + id + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

}
