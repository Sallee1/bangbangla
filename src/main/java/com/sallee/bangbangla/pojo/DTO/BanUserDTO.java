package com.sallee.bangbangla.pojo.DTO;

public class BanUserDTO {
	Integer banId;
	Integer dayLen;
	Integer opId;
	String result;
	
	public BanUserDTO(){}

	public BanUserDTO(Integer userId, Integer dayLen, Integer opId, String result) {
		this.banId = userId;
		this.dayLen = dayLen;
		this.opId = opId;
		this.result = result;
	}

	public Integer getBanId() {
		return banId;
	}

	public void setBanId(Integer banId) {
		this.banId = banId;
	}

	public Integer getDayLen() {
		return dayLen;
	}


	public void setDayLen(Integer dayLen) {
		this.dayLen = dayLen;
	}

	public Integer getOpId() {
		return opId;
	}

	public void setOpId(Integer opId) {
		this.opId = opId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
