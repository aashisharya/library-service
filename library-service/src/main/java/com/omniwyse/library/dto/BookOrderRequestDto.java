package com.omniwyse.library.dto;

import java.util.Date;

public class BookOrderRequestDto {
	private Date orderDate;
	private Date desiredDate;
	private String username;
	private Date releaseDate;
	private double totalRent;
	private double paid;
	private double due;
	private String currency;
	private AddressDto source;
	private AddressDto destination;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDesiredDate() {
		return desiredDate;
	}

	public void setDesiredDate(Date desiredDate) {
		this.desiredDate = desiredDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(double totalRent) {
		this.totalRent = totalRent;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public double getDue() {
		return due;
	}

	public void setDue(double due) {
		this.due = due;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public AddressDto getSource() {
		return source;
	}

	public void setSource(AddressDto source) {
		this.source = source;
	}

	public AddressDto getDestination() {
		return destination;
	}

	public void setDestination(AddressDto destination) {
		this.destination = destination;
	}

}
