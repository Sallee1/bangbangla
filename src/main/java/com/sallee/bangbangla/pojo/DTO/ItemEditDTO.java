package com.sallee.bangbangla.pojo.DTO;


public class ItemEditDTO {
	Integer itemId;
	Integer score;

	public ItemEditDTO() {}

	public ItemEditDTO(Integer itemId, Integer score) {
		this.itemId = itemId;
		this.score = score;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
