package com.sallee.bangbangla.pojo.DTO;


public class UserBriefInfoDTO {
	public Integer id;
	public String userName;
	public String nickName;
	public String universityPos;
	public String universityName;

	public UserBriefInfoDTO() {}

	public UserBriefInfoDTO(Integer id, String userName, String nickName, String universityPos, String universityName) {
		this.id = id;
		this.userName = userName;
		this.nickName = nickName;
		this.universityPos = universityPos;
		this.universityName = universityName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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
}
