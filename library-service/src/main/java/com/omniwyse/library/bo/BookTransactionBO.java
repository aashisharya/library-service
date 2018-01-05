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
@Table(name = "BOOK_TRANSACTION_QUEUE")
public class BookTransactionBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "transaction_date")
	private Date transactionDate;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookOrderLineItemBO orederLineItem;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookBO book;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserBO agent;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserBO owner;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private LibraryLocationBO location;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private LibraryBO library;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private DeliveryTypeBO deliveryType;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookFlagBO bookFlag;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookStatusBO bookStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BookOrderLineItemBO getOrederLineItem() {
		return orederLineItem;
	}

	public void setOrederLineItem(BookOrderLineItemBO orederLineItem) {
		this.orederLineItem = orederLineItem;
	}

	public BookBO getBook() {
		return book;
	}

	public void setBook(BookBO book) {
		this.book = book;
	}

	public UserBO getAgent() {
		return agent;
	}

	public void setAgent(UserBO agent) {
		this.agent = agent;
	}

	public UserBO getOwner() {
		return owner;
	}

	public void setOwner(UserBO owner) {
		this.owner = owner;
	}

	public LibraryLocationBO getLocation() {
		return location;
	}

	public void setLocation(LibraryLocationBO location) {
		this.location = location;
	}

	public DeliveryTypeBO getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryTypeBO deliveryType) {
		this.deliveryType = deliveryType;
	}

	public BookFlagBO getBookFlag() {
		return bookFlag;
	}

	public void setBookFlag(BookFlagBO bookFlag) {
		this.bookFlag = bookFlag;
	}

	public BookStatusBO getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(BookStatusBO bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LibraryBO getLibrary() {
		return library;
	}

	public void setLibrary(LibraryBO library) {
		this.library = library;
	}

}
