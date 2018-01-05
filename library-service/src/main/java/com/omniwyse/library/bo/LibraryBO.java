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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "LIBRARY")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LibraryBO {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private long id;
	@Column(name = "library_name",unique = true, nullable = false)
	private String name;
	private String longitude;
	private String latitude;
	@Column(name = "est_date" )
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date estDate;
	@Column(name = "no_of_books")
	private String noOfBooks;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private LibraryLocationBO location;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private AddressBO address;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional  = false)
	private UserBO superAdmin;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	public String getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(String noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	@JsonIgnore
	public LibraryLocationBO getLocation() {
		return location;
	}

	public void setLocation(LibraryLocationBO location) {
		this.location = location;
	}

	@JsonIgnore
	public AddressBO getAddress() {
		return address;
	}

	public void setAddress(AddressBO address) {
		this.address = address;
	}

	@JsonIgnore
	public UserBO getSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(UserBO superAdmin) {
		this.superAdmin = superAdmin;
	}

}
