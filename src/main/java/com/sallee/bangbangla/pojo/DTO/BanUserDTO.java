package com.sallee.bangbangla.pojo.DTO;


public class BanUserDTO {
	Integer userId;
	Long timeLen;

	public BanUserDTO(){}

	public BanUserDTO(Integer userId, Long timeLen) {
		this.userId = userId;
		this.timeLen = timeLen;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getTimeLen() {
		return timeLen;
	}

	public void setTimeLen(Long timeLen) {
		this.timeLen = timeLen;
	}
}
