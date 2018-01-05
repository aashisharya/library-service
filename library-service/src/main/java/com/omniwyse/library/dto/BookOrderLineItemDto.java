package com.omniwyse.library.dto;

import java.util.Date;

public class BookOrderLineItemDto {
	private long id;
	private Date orderDate;
	private Date desireDate;
	private Date releaseDate;
	private Double bookPrice;
	private BookOrderDto order;
	private UserDto customer;
	private UserDto owner;
	private LibraryDto library;
	private BookStatusDto bookStatus;
	private AddressDto source;
	private AddressDto destination;
	private BookDto book;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDesireDate() {
		return desireDate;
	}

	public void setDesireDate(Date desireDate) {
		this.desireDate = desireDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public BookOrderDto getOrder() {
		return order;
	}

	public void setOrder(BookOrderDto order) {
		this.order = order;
	}

	public UserDto getCustomer() {
		return customer;
	}

	public void setCustomer(UserDto customer) {
		this.customer = customer;
	}

	public BookStatusDto getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(BookStatusDto bookStatus) {
		this.bookStatus = bookStatus;
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

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public UserDto getOwner() {
		return owner;
	}

	public void setOwner(UserDto owner) {
		this.owner = owner;
	}

	public LibraryDto getLibrary() {
		return library;
	}

	public void setLibrary(LibraryDto library) {
		this.library = library;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

}