package com.sallee.bangbangla.pojo.VO;


public class UserInfoVO {
	Integer userId;
	String userName;
	String sex;
	String nickName;
	String introduction;
	String realName;
	String idCard;
	String realTel;
	String universityPos;
	String universityName;
	String studentId;
	Integer score;
	Integer totalCredit;
	Integer creditCount;

	public UserInfoVO() {
	}

	public UserInfoVO(Integer userId, String userName, String sex, String nickName, String introduction, String realName,
										String idCard, String realTel, String universityPos, String universityName, String studentId,
										Integer score, Integer totalCredit, Integer creditCount) {
		this.userId = userId;
		this.userName = userName;
		this.sex = sex;
		this.nickName = nickName;
		this.introduction = introduction;
		this.realName = realName;
		this.idCard = idCard;
		this.realTel = realTel;
		this.universityPos = universityPos;
		this.universityName = universityName;
		this.studentId = studentId;
		this.score = score;
		this.totalCredit = totalCredit;
		this.creditCount = creditCount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getRealTel() {
		return realTel;
	}

	public void setRealTel(String realTel) {
		this.realTel = realTel;
	}

	public String getUniversityPos() {
		return universityPos;
	}

	public void setUniversityPos(String universityPos) {
		this.universityPos = universityPos;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(Integer totalCredit) {
		this.totalCredit = totalCredit;
	}

	public Integer getCreditCount() {
		return creditCount;
	}

	public void setCreditCount(Integer creditCount) {
		this.creditCount = creditCount;
	}
}
