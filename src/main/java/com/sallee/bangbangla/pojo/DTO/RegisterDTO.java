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

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(java.lang.String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public java.lang.String getSex() {
		return sex;
	}

	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	public java.lang.String getNickName() {
		return nickName;
	}

	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	public java.lang.String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(java.lang.String introduction) {
		this.introduction = introduction;
	}

	

	public java.lang.String getRealName() {
		return realName;
	}

	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}

	public java.lang.String getIdCard() {
		return idCard;
	}

	public void setIdCard(java.lang.String idCard) {
		this.idCard = idCard;
	}

	public java.lang.String getRealTel() {
		return realTel;
	}

	public void setRealTel(java.lang.String realTel) {
		this.realTel = realTel;
	}

	public java.lang.String getUniversityPos() {
		return universityPos;
	}

	public void setUniversityPos(java.lang.String universityPos) {
		this.universityPos = universityPos;
	}

	public java.lang.String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(java.lang.String universityName) {
		this.universityName = universityName;
	}

	public java.lang.String getStudentId() {
		return studentId;
	}

	public void setStudentId(java.lang.String studentId) {
		this.studentId = studentId;
	}
}
