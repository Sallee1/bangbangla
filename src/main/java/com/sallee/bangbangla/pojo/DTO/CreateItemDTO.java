package com.sallee.bangbangla.pojo.DTO;


import java.nio.file.Files;
import java.util.List;

public class CreateItemDTO {
	Integer sellerId;
	String title;
	String introduce;
	Integer price;
	List<String> imageData;
	String mainLabel;
	List<String> subLabel;

	public CreateItemDTO(){}

	public CreateItemDTO(Integer sellerId, String title, String introduce, Integer price, List<String> imageData,
											 String mainLabel, List<String> subLabel) {
		this.sellerId = sellerId;
		this.title = title;
		this.introduce = introduce;
		this.price = price;
		this.imageData = imageData;
		this.mainLabel = mainLabel;
		this.subLabel = subLabel;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<String> getImageData() {
		return imageData;
	}

	public void setImageData(List<String> imageData) {
		this.imageData = imageData;
	}

	public String getMainLabel() {
		return mainLabel;
	}

	public void setMainLabel(String mainLabel) {
		this.mainLabel = mainLabel;
	}

	public List<String> getSubLabel() {
		return subLabel;
	}

	public void setSubLabel(List<String> subLabel) {
		this.subLabel = subLabel;
	}
}
