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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "BOOK_INVENTORY")
public class BookInventoryBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	@Type(type = "yes_no")
	private boolean isAvailable;
	@Column(name = "book_sale_price")
	private double bookSalePrice;
	@Column(name = "book_rent_price", nullable = false)
	private double bookRentalPrice;
	@Column(name = "available_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date availableDate;
	@Type(type = "yes_no")
	@Column(nullable = false)
	private boolean isBuyable;
	@Type(type = "yes_no")
	@Column(nullable = false)
	private boolean isRental;
	@Column(name = "total_no_of_books")
	private Long totalNoOfBooks;
	@Column(name = "no_of_books_available")
	private Long NoOfBooksAvailable;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserBO owner;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookBO book;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private LibraryBO library;

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

	public UserBO getOwner() {
		return owner;
	}

	public void setOwner(UserBO owner) {
		this.owner = owner;
	}

	public BookBO getBook() {
		return book;
	}

	public void setBook(BookBO book) {
		this.book = book;
	}

	public LibraryBO getLibrary() {
		return library;
	}

	public void setLibrary(LibraryBO library) {
		this.library= library;
	}

}
