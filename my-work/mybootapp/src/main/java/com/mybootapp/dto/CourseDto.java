package com.mybootapp.dto;

public class CourseDto {
	private String courseName;
	private double fee;
	private int credits;
	private String departmentName;

	public CourseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseDto(String courseName, double fee, int credits, String departmentName) {
		super();
		this.courseName = courseName;
		this.fee = fee;
		this.credits = credits;
		this.departmentName = departmentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "CourseDto [courseName=" + courseName + ", fee=" + fee + ", credits=" + credits + ", departmentName="
				+ departmentName + "]";
	}

}
