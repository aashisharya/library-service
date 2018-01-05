package com.omniwyse.library.dto;

import java.util.Date;

public class BookInventoryDto {
	private long id;
	private boolean isAvailable;
	private double bookSalePrice;
	private double bookRentalPrice;
	private Date availableDate;
	private boolean isBuyable;
	private boolean isRental;
	private Long totalNoOfBooks;
	private Long NoOfBooksAvailable;
	private UserDto owner;
	private BookDto book;
	private LibraryDto library;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getBookSalePrice() {
		return bookSalePrice;
	}

	public void setBookSalePrice(double bookSalePrice) {
		this.bookSalePrice = bookSalePrice;
	}

	public double getBookRentalPrice() {
		return bookRentalPrice;
	}

	public void setBookRentalPrice(double bookRentalPrice) {
		this.bookRentalPrice = bookRentalPrice;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public boolean isBuyable() {
		return isBuyable;
	}

	public void setBuyable(boolean isBuyable) {
		this.isBuyable = isBuyable;
	}

	public boolean isRental() {
		return isRental;
	}

	public void setRental(boolean isRental) {
		this.isRental = isRental;
	}

	public Long getTotalNoOfBooks() {
		return totalNoOfBooks;
	}

	public void setTotalNoOfBooks(Long totalNoOfBooks) {
		this.totalNoOfBooks = totalNoOfBooks;
	}

	public Long getNoOfBooksAvailable() {
		return NoOfBooksAvailable;
	}

	public void setNoOfBooksAvailable(Long noOfBooksAvailable) {
		NoOfBooksAvailable = noOfBooksAvailable;
	}

	public UserDto getOwner() {
		return owner;
	}

	public void setOwner(UserDto owner) {
		this.owner = owner;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public LibraryDto getLibrary() {
		return library;
	}

	public void setLibrary(LibraryDto library) {
		this.library = library;
	}

}
