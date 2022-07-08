package com.sallee.bangbangla.pojo.VO;


import java.util.List;

public class OrderLogDetailVO {
	Integer orderId;
	String title;
	String createTime;
	Integer score;
	String mainLabel;
	String subLabel;
	String introduce;
	String payState;
	String state;
	List<UserCreditVO> wantList;

	public OrderLogDetailVO() {
	}

	public OrderLogDetailVO(Integer orderId, String title, String createTime, Integer score, String mainLabel,
													String subLabel, String introduce, String payState, String state,
													List<UserCreditVO> wantList) {
		this.orderId = orderId;
		this.title = title;
		this.createTime = createTime;
		this.score = score;
		this.mainLabel = mainLabel;
		this.subLabel = subLabel;
		this.introduce = introduce;
		this.payState = payState;
		this.state = state;
		this.wantList = wantList;
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getMainLabel() {
		return mainLabel;
	}

	public void setMainLabel(String mainLabel) {
		this.mainLabel = mainLabel;
	}

	public String getSubLabel() {
		return subLabel;
	}

	public void setSubLabel(String subLabel) {
		this.subLabel = subLabel;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<UserCreditVO> getWantList() {
		return wantList;
	}

	public void setWantList(List<UserCreditVO> wantList) {
		this.wantList = wantList;
	}
}
