package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("order_history")
public class OrdersHistoryDAO {
	Integer id;
	Integer sellerId;
	Integer buyerId;
	Long createTime;
	Long dealTime;
	Long finishTime;
	Integer state;
	Integer payState;
	String title;
	String introduce;
	Integer price;
	List<String> imagePaths;
	Integer mainLabel;
	List<String> subLabel;
	String commit;

	public OrdersHistoryDAO(){}

	public OrdersHistoryDAO(Integer id, Integer sellerId, Integer buyerId, Long createTime, Long dealTime, Long finishTime,
									 Integer state, Integer payState, String title, String introduce, Integer price, List<String> imagePaths,
									 Integer mainLabel, List<String> subLabel, String commit) {
		this.id = id;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.createTime = createTime;
		this.dealTime = dealTime;
		this.finishTime = finishTime;
		this.state = state;
		this.payState = payState;
		this.title = title;
		this.introduce = introduce;
		this.price = price;
		this.imagePaths = imagePaths;
		this.mainLabel = mainLabel;
		this.subLabel = subLabel;
		this.commit = commit;
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

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
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

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}
}