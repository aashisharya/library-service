package com.omniwyse.library.dto;

public class LibraryAgentDto {
	private long id;
	private LibraryDto library;
	private UserDto agent;
	private UserDto admin;

	public LibraryAgentDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LibraryDto getLibrary() {
		return library;
	}

	public void setLibrary(LibraryDto library) {
		this.library = library;
	}

	public UserDto getAgent() {
		return agent;
	}

	public void setAgent(UserDto agent) {
		this.agent = agent;
	}

	public UserDto getAdmin() {
		return admin;
	}

	public void setAdmin(UserDto admin) {
		this.admin = admin;
	}

}
