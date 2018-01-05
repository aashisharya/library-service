package com.omniwyse.library.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BOOK_FLAG")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BookFlagBO {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String flag;

	public long getId() {
		return id;
	}

	public String getFlag() {
		return flag;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
