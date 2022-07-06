package com.sallee.bangbangla.pojo.DTO;


public class EditInfoDTO {
	String sex;
	String nickName;
	String introduction;

	public EditInfoDTO() {}

	public EditInfoDTO(String sex, String nickName, String introduction) {
		this.sex = sex;
		this.nickName = nickName;
		this.introduction = introduction;
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
