package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.List;

@TableName("order_history")
public class OrderHistoryDAO {
	Integer id;
	Integer sellerId;
	Integer buyerId;
	Date createTime;
	Date dealTime;
	Date finishTime;
	Integer state;
	Integer payState;
	String title;
	String introduce;
	Integer price;
	List<String> imagePaths;
	Integer mainLabel;
	List<String> subLabel;
	String commit;

	Integer credit;

	public OrderHistoryDAO(){}

	public OrderHistoryDAO(Integer id, Integer sellerId, Integer buyerId, Date createTime, Date dealTime, Date finishTime,
												 Integer state, Integer payState, String title, String introduce, Integer price, List<String> imagePaths,
												 Integer mainLabel, List<String> subLabel, String commit,int credit) {
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
		this.credit = credit;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
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

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}
}
