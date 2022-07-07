package com.sallee.bangbangla.pojo.DTO;


import java.util.Date;

public class BanUserDTO {
	Integer userId;
	Date timeLen;

	public BanUserDTO(){}

	public BanUserDTO(Integer userId, Date timeLen) {
		this.userId = userId;
		this.timeLen = timeLen;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTimeLen() {
		return timeLen;
	}

	public void setTimeLen(Date timeLen) {
		this.timeLen = timeLen;
	}
}
