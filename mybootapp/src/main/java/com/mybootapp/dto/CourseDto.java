package com.mybootapp.dto;

public class CourseDto {
	private String name;
	private Integer credits;
	private Double fee;
	private String departmentName;

	public CourseDto(String name, Integer credits, Double fee, String departmentName) {
		super();
		this.name = name;
		this.credits = credits;
		this.fee = fee;
		this.departmentName = departmentName;
	}

	public CourseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "CourseDto [name=" + name + ", credits=" + credits + ", fee=" + fee + ", departmentName="
				+ departmentName + "]";
	}

}
