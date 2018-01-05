package com.omniwyse.library.dto;

import java.util.Date;

public class PickupTimingDto {

	private long id;
	private Date time;
	private WeekdaysDto weekday;
	private UserDto user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public WeekdaysDto getWeekday() {
		return weekday;
	}

	public void setWeekday(WeekdaysDto weekday) {
		this.weekday = weekday;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

}
