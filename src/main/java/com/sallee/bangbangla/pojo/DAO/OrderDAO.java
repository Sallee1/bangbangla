package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("orders")
public class OrderDAO {
	@TableId(type = IdType.AUTO)//设置id为主键，id的值是由数据库自动生成
	Integer id;
	Integer sellerId;
	Integer buyerId;
	Integer itemId;
	Integer payState;
	Integer state;
	Long dealTime;

//	public OrderDAO(){}
//
//	public OrderDAO(Integer id, Integer sellerId, Integer buyerId, Integer itemId,
//									Integer payState, Integer state, Long dealTime) {
//		this.id = id;
//		this.sellerId = sellerId;
//		this.buyerId = buyerId;
//		this.itemId = itemId;
//		this.payState = payState;
//		this.state = state;
//		this.dealTime = dealTime;
//	}

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

	public Long getDealTime() {
		return dealTime;
	}

	public void setDealTime(Long dealTime) {
		this.dealTime = dealTime;
	}
}
