package com.omniwyse.library.bo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_ORDER")
public class BookOrderBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "order_date")
	private Date orderDate;
	@Column(name = "total_amount")
	private double totalAmount;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookStatusBO status;
	private double paid;
	private double due;
	@Column(name = "delivery_time")
	private Date deliveryTime;
	@Column(name = "delivery_type")
	private String deliveryType;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserBO user;

	public long getId() {
		return id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public UserBO getUser() {
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

	public void setUser(UserBO user) {
		this.user = user;
	}

	public BookStatusBO getStatus() {
		return status;
	}

	public void setStatus(BookStatusBO status) {
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
