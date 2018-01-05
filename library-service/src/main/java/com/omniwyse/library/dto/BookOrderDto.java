package com.omniwyse.library.dto;

import java.util.Date;

public class BookOrderDto {
	private long id;
	private Date orderDate;
	private double totalAmount;
	private BookStatusDto status;
	private double paid;
	private double due;
	private Date deliveryTime;
	private String deliveryType;
	private UserDto user;

	public long getId() {
		return id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public UserDto getUser() {
		return user;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public BookStatusDto getStatus() {
		return status;
	}

	public void setStatus(BookStatusDto status) {
		this.status = status;
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

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

}
