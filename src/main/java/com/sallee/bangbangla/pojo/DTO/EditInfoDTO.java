package com.sallee.bangbangla.pojo.DTO;


public class EditInfoDTO {
	Integer userId;
	String sex;
	String nickName;
	String introduction;

	public EditInfoDTO() {}

	public EditInfoDTO(Integer userId,String sex, String nickName, String introduction) {
		this.userId = userId;
		this.sex = sex;
		this.nickName = nickName;
		this.introduction = introduction;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}
