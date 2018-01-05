package com.omniwyse.library.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY_ADMIN_AGENT")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LibraryAgentBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private LibraryBO library;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserBO agent;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserBO admin;

	//To create agent admin for library
	public LibraryAgentBO(LibraryBO library, UserBO agent) {
		super();
		this.library = library;
		this.agent = agent;
	}
	//To create user admin for library
	public LibraryAgentBO(UserBO admin, LibraryBO library) {
		super();
		this.admin = admin;
		this.library = library;
	}

	public LibraryAgentBO() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LibraryBO getLibrary() {
		return library;
	}

	public void setLibrary(LibraryBO library) {
		this.library = library;
	}

	public UserBO getAgent() {
		return agent;
	}

	public void setAgent(UserBO agent) {
		this.agent = agent;
	}

	public UserBO getAdmin() {
		return admin;
	}

	public void setAdmin(UserBO admin) {
		this.admin = admin;
	}

}
