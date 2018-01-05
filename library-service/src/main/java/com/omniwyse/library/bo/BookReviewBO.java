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
@Table(name = "BOOK_REVIEW")
public class BookReviewBO {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private long id;
	@Column(name = "review_text")
	private String reviewText;
	private int bookLike;
	private int dislike;
	private int shares;
	@Column(name ="review_date")
	private Date reviewDate;
	@ManyToOne(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	private UserBO user;
	@ManyToOne(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	private BookBO book;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public int getBookLike() {
		return bookLike;
	}

	public void setBookLike(int bookLike) {
		this.bookLike = bookLike;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public BookBO getBook() {
		return book;
	}

	public void setBook(BookBO book) {
		this.book = book;
	}

}
