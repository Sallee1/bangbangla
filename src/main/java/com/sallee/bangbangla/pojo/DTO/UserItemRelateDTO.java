package com.sallee.bangbangla.pojo.DTO;


public class UserItemRelateDTO {
	public Integer userId;
	public Integer itemId;

	public UserItemRelateDTO() {}

	public UserItemRelateDTO(Integer userId, Integer itemId) {
		this.userId = userId;
		this.itemId = itemId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
}
