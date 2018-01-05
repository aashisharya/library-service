package com.omniwyse.library.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Table(name = "BOOKS_INFO")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BookBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "title", nullable = false)
	private String title;
	private String author;
	@Column(name = "isbn_code")
	private String isbnCode;
	private String genres;
	private String edition;
	@Column(name = "publish_date")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String publishDate;
	@Column(name = "book_cover_page")
	private String bookCoverPage;
	@Column(name = "sample_page_url")
	private String samplePageUrl;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "book_price")
	private double bookPrice;
	@Column(name = "book_rent_value")
	private double bookRentalValue;
	private String description;
	@Column(name = "no_of_pages")
	private int noOfPages;
	private String publisher;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getBookCoverPage() {
		return bookCoverPage;
	}

	public void setBookCoverPage(String bookCoverPage) {
		this.bookCoverPage = bookCoverPage;
	}

	public String getSamplePageUrl() {
		return samplePageUrl;
	}

	public void setSamplePageUrl(String samplePageUrl) {
		this.samplePageUrl = samplePageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getBookRentalValue() {
		return bookRentalValue;
	}

	public void setBookRentalValue(double bookRentalValue) {
		this.bookRentalValue = bookRentalValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
