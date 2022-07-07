package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("orders")
public class OrderDAO {
	Integer id;
	Integer sellerId;
	Integer buyerId;
	Integer itemId;
	Integer payState;
	Integer state;
	Date dealTime;

	public OrderDAO(){}

	public OrderDAO(Integer id, Integer sellerId, Integer buyerId, Integer itemId,
									Integer payState, Integer state, Date dealTime) {
		this.id = id;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.itemId = itemId;
		this.payState = payState;
		this.state = state;
		this.dealTime = dealTime;
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

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
}
