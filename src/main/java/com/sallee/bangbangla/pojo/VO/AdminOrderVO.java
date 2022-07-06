package com.sallee.bangbangla.pojo.VO;


import java.util.List;

public class AdminOrderVO {
	Integer id;
	Integer sellerId;
	String sellerUserName;
	Integer buyerId;
	String buyerUserName;
	Long createTime;
	Long dealTime;
	Long finishTime;
	String state;
	String title;
	String introduce;
	Integer price;
	List<String> imagePaths;
	String mainLabel;
	List<String> subLabel;

	public AdminOrderVO() {}

	public AdminOrderVO(Integer id, Integer sellerId, String sellerUserName, Integer buyerId, String buyerUserName,
											Long createTime, Long dealTime, Long finishTime, String state, String title, String introduce,
											Integer price, List<String> imagePaths, String mainLabel, List<String> subLabel) {
		this.id = id;
		this.sellerId = sellerId;
		this.sellerUserName = sellerUserName;
		this.buyerId = buyerId;
		this.buyerUserName = buyerUserName;
		this.createTime = createTime;
		this.dealTime = dealTime;
		this.finishTime = finishTime;
		this.state = state;
		this.title = title;
		this.introduce = introduce;
		this.price = price;
		this.imagePaths = imagePaths;
		this.mainLabel = mainLabel;
		this.subLabel = subLabel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerUserName() {
		return sellerUserName;
	}

	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerUserName() {
		return buyerUserName;
	}

	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getDealTime() {
		return dealTime;
	}

	public void setDealTime(Long dealTime) {
		this.dealTime = dealTime;
	}

	public Long getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Long finishTime) {
		this.finishTime = finishTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public List<String> getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(List<String> imagePaths) {
		this.imagePaths = imagePaths;
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
