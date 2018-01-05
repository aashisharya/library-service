package com.omniwyse.library.dto;

public class BookDto {
	private long id;
	private String title;
	private String author;
	private String isbnCode;
	private String genres;
	private String edition;
	private String publishDate;
	private String bookCoverPage;
	private String samplePageUrl;
	private String imageUrl;
	private double bookPrice;
	private double bookRentalValue;
	private String description;
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
