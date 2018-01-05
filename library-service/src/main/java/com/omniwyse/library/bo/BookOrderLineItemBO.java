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
@Table(name = "BOOK_ORDER_LINE_ITEMS")
public class BookOrderLineItemBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "order_date")
	private Date orderDate;
	@Column(name = "desire_date")
	private Date desireDate;
	@Column(name = "release_date")
	private Date releaseDate;
	@Column(name = "book_price")
	private Double bookPrice;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookOrderBO order;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserBO customer;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserBO owner;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private LibraryBO library;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookStatusBO bookStatus;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private AddressBO source;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private AddressBO destination;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookBO book;

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

	public BookOrderBO getOrder() {
		return order;
	}

	public void setOrder(BookOrderBO order) {
		this.order = order;
	}

	public UserBO getCustomer() {
		return customer;
	}

	public void setCustomer(UserBO customer) {
		this.customer = customer;
	}

	public BookStatusBO getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(BookStatusBO bookStatus) {
		this.bookStatus = bookStatus;
	}

	public AddressBO getSource() {
		return source;
	}

	public void setSource(AddressBO source) {
		this.source = source;
	}

	public AddressBO getDestination() {
		return destination;
	}

	public void setDestination(AddressBO destination) {
		this.destination = destination;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public UserBO getOwner() {
		return owner;
	}

	public void setOwner(UserBO owner) {
		this.owner = owner;
	}

	public LibraryBO getLibrary() {
		return library;
	}

	public void setLibrary(LibraryBO library) {
		this.library = library;
	}

	public BookBO getBook() {
		return book;
	}

	public void setBook(BookBO book) {
		this.book = book;
	}

}