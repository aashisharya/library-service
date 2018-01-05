package com.omniwyse.library.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "category")
@Entity
public class CategoryBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String category;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BookBO book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BookBO getBook() {
		return book;
	}

	public void setBook(BookBO book) {
		this.book = book;
	}

}
