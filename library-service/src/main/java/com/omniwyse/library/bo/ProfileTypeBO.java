package com.omniwyse.library.bo;

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
@Table(name = "PROFILE_TYPE")
public class ProfileTypeBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "profile_type")
	private String profileType;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BookBO book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileType() {
		return profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

	public BookBO getBook() {
		return book;
	}

	public void setBook(BookBO book) {
		this.book = book;
	}

}
