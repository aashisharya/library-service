package com.omniwyse.library.dto;

import java.util.Collection;
import java.util.Date;

public class RoleDto {

	private Long id;
	private String role;
	private String description;
	private Date createdOn;
	private Date modifiedOn;
	private Collection<UserDto> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Collection<UserDto> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDto> users) {
		this.users = users;
	}

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "roles_privileges", joinColumns = @JoinColumn( name =
	 * "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(
	 * name = "privilege_id", referencedColumnName = "id")) private
	 * Collection<Privilege> privileges;
	 */

}
