package com.bootapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LeaveRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String comments;
	@ManyToOne
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "LeaveRequest [id=" + id + ", comments=" + comments + ", employee=" + employee + "]";
	}

}
