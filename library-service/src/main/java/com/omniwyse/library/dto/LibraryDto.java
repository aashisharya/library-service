package com.omniwyse.library.dto;

import java.util.Date;

public class LibraryDto {

	private long id;
	private String name;
	private String longitude;
	private String latitude;
	private Date estDate;
	private String noOfBooks;
	private LibraryLocationDto location;
	private AddressDto address;
	private UserDto superAdmin;

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

	public LibraryLocationDto getLocation() {
		return location;
	}

	public void setLocation(LibraryLocationDto location) {
		this.location = location;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public UserDto getSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(UserDto superAdmin) {
		this.superAdmin = superAdmin;
	}

}
