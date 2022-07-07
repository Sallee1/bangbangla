package com.sallee.bangbangla.pojo.VO;


import java.util.Date;
import java.util.List;

public class ItemVO {
	Integer itemId;
	String sellerNickName;
	Float sellerCredit;
	Date createTime;
	String title;
	Integer price;
	String imagePath;
	String mainLabel;
	List<String> subLabel;
	Integer want_count;
	Integer view_count;

	public ItemVO() {
	}

	public ItemVO(Integer itemId, String sellerNickName, Float sellerCredit, Date createTime, String title, Integer price,
								String imagePath, String mainLabel, List<String> subLabel, Integer want_count, Integer view_count) {
		this.itemId = itemId;
		this.sellerNickName = sellerNickName;
		this.sellerCredit = sellerCredit;
		this.createTime = createTime;
		this.title = title;
		this.price = price;
		this.imagePath = imagePath;
		this.mainLabel = mainLabel;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
