package com.sallee.bangbangla.pojo.VO;


import java.util.Date;
import java.util.List;

public class ItemDetailVO {
	Integer itemId;
	String sellerNickName;
	Float sellerCredit;
	String createTime;
	String title;
	String introduce;
	Integer price;
	String imagePaths;
	String mainLable;
	String subLabel;
	Integer want_count;
	Integer view_count;

	public ItemDetailVO() {}

	public ItemDetailVO(Integer itemId, String sellerNickName, Float sellerCredit, Date createTime, String title,
											String introduce, Integer price, String imagePaths, String mainLable, String subLabel,
											Integer want_count, Integer view_count) {
		this.itemId = itemId;
		this.sellerNickName = sellerNickName;
		this.sellerCredit = sellerCredit;
		this.createTime = createTime.toString();
		this.title = title;
		this.introduce = introduce;
		this.price = price;
		this.imagePaths = imagePaths;
		this.mainLable = mainLable;
		this.subLabel = subLabel;
		this.want_count = want_count;
		this.view_count = view_count;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getSellerNickName() {
		return sellerNickName;
	}

	public void setSellerNickName(String sellerNickName) {
		this.sellerNickName = sellerNickName;
	}

	public Float getSellerCredit() {
		return sellerCredit;
	}

	public void setSellerCredit(Float sellerCredit) {
		this.sellerCredit = sellerCredit;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public String getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(String imagePaths) {
		this.imagePaths = imagePaths;
	}

	public String getMainLable() {
		return mainLable;
	}

	public void setMainLable(String mainLable) {
		this.mainLable = mainLable;
	}

	public String getSubLabel() {
		return subLabel;
	}

	public void setSubLabel(String subLabel) {
		this.subLabel = subLabel;
	}

	public Integer getWant_count() {
		return want_count;
	}

	public void setWant_count(Integer want_count) {
		this.want_count = want_count;
	}

	public Integer getView_count() {
		return view_count;
	}

	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}
}
