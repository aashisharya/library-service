package com.omniwyse.library.dto;

public class BookRecomendDto {
	private long id;
	private String criteria;
	private String type;
	private String displayText;
	private boolean displayOnWeb;
	private boolean orderNO;
	private UserDto user;

	public long getId() {
		return id;
	}

	public String getCriteria() {
		return criteria;
	}

	public String getType() {
		return type;
	}

	public String getDisplayText() {
		return displayText;
	}

	public boolean isDisplayOnWeb() {
		return displayOnWeb;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public void setDisplayOnWeb(boolean displayOnWeb) {
		this.displayOnWeb = displayOnWeb;
	}

	public boolean isOrderNO() {
		return orderNO;
	}

	public void setOrderNO(boolean orderNO) {
		this.orderNO = orderNO;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

}
