package com.omniwyse.library.dto;

import java.util.Date;

public class BookTransactionDto {
	private long id;
	private Date transactionDate;
	private BookOrderLineItemDto orederLineItem;
	private BookDto book;
	private UserDto agent;
	private UserDto owner;
	private LibraryLocationDto location;
	private LibraryDto library;
	private DeliveryTypeDto deliveryType;
	private BookFlagDto bookFlag;
	private BookStatusDto bookStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BookOrderLineItemDto getOrederLineItem() {
		return orederLineItem;
	}

	public void setOrederLineItem(BookOrderLineItemDto orederLineItem) {
		this.orederLineItem = orederLineItem;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public UserDto getAgent() {
		return agent;
	}

	public void setAgent(UserDto agent) {
		this.agent = agent;
	}

	public UserDto getOwner() {
		return owner;
	}

	public void setOwner(UserDto owner) {
		this.owner = owner;
	}

	public LibraryLocationDto getLocation() {
		return location;
	}

	public void setLocation(LibraryLocationDto location) {
		this.location = location;
	}

	public DeliveryTypeDto getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryTypeDto deliveryType) {
		this.deliveryType = deliveryType;
	}

	public BookFlagDto getBookFlag() {
		return bookFlag;
	}

	public void setBookFlag(BookFlagDto bookFlag) {
		this.bookFlag = bookFlag;
	}

	public BookStatusDto getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(BookStatusDto bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LibraryDto getLibrary() {
		return library;
	}

	public void setLibrary(LibraryDto library) {
		this.library = library;
	}

}
