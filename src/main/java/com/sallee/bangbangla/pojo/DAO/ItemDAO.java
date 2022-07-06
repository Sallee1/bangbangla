package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("items")
public class ItemDAO {
	Integer id;
	Integer sellerId;
	Long createTime;
	Integer state;
	String title;
	String introduce;
	Integer price;
	List<String> imagePaths;
	Integer mainLabel;
	List<String> subLabel;
	Integer want_count;
	Integer view_count;

	public ItemDAO(){}

	public ItemDAO(Integer id, Integer sellerId, Long createTime, Integer state, String title, String introduce,
								 Integer price, List<String> imagePaths, Integer mainLabel, List<String> subLabel, Integer want_count,
								 Integer view_count) {
		this.id = id;
		this.sellerId = sellerId;
		this.createTime = createTime;
		this.state = state;
		this.title = title;
		this.introduce = introduce;
		this.price = price;
		this.imagePaths = imagePaths;
		this.mainLabel = mainLabel;
		this.subLabel = subLabel;
		this.want_count = want_count;
		this.view_count = view_count;
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

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
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

	public Integer getMainLabel() {
		return mainLabel;
	}

	public void setMainLabel(Integer mainLabel) {
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
