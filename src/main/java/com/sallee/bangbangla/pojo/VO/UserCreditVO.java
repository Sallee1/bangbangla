package com.sallee.bangbangla.pojo.VO;


public class UserCreditVO {
	Integer userId;
	String nickName;
	Float userCredit;

	public UserCreditVO() {
	}

	public UserCreditVO(Integer userId, String nickName, Float userCredit) {
		this.userId = userId;
		this.nickName = nickName;
		this.userCredit = userCredit;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Float getUserCredit() {
		return userCredit;
	}

	public void setUserCredit(Float userCredit) {
		this.userCredit = userCredit;
	}
}
