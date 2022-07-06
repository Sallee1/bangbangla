package com.sallee.bangbangla.pojo.DTO;


public class RegisterDTO {
	String userName;
	String password;
	String passwordAgain;
	String sex;
	String nickName;
	String introduction;
	String realName;
	String idCard;
	String realTel;
	String universityPos;
	String universityName;
	String studentId;

	public RegisterDTO() {}

	public RegisterDTO(String userName, String password, String passwordAgain, String sex, String nickName,
										 String introduction, String realName, String idCard, String realTel, String universityPos,
										 String universityName, String studentId) {
		this.userName = userName;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.sex = sex;
		this.nickName = nickName;
		this.introduction = introduction;
		this.realName = realName;
		this.idCard = idCard;
		this.realTel = realTel;
		this.universityPos = universityPos;
		this.universityName = universityName;
		this.studentId = studentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
