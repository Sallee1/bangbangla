package com.sallee.bangbangla.pojo.VO;


import java.util.Date;

public class OrderLogVO {
	Integer orderId;
	String title;
	String createTime;
	String state;

	public OrderLogVO() {
	}

	public OrderLogVO(Integer orderId, String title, String createTime, String state) {
		this.orderId = orderId;
		this.title = title;
		this.createTime = createTime;
		this.state = state;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
