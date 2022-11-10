package com.mybootapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String source;
	private String destination;
	private LocalDate depdate;
	private String deptime;
	private LocalDate arrdate;
	private String arrtime;
	private double duration;
	private double adultfare;
	private double childfare;
	private int seats;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDepdate() {
		return depdate;
	}
	public void setDepdate(LocalDate depdate) {
		this.depdate = depdate;
	}
	public String getDeptime() {
		return deptime;
	}
	public void setDeptime(String deptime) {
		this.deptime = deptime;
	}
	public LocalDate getArrdate() {
		return arrdate;
	}
	public void setArrdate(LocalDate arrdate) {
		this.arrdate = arrdate;
	}
	public String getArrtime() {
		return arrtime;
	}
	public void setArrtime(String arrtime) {
		this.arrtime = arrtime;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getAdultfare() {
		return adultfare;
	}
	public void setAdultfare(double adultfare) {
		this.adultfare = adultfare;
	}
	public double getChildfare() {
		return childfare;
	}
	public void setChildfare(double childfare) {
		this.childfare = childfare;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	

}
	