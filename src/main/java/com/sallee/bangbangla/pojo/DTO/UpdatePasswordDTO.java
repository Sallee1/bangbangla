package com.sallee.bangbangla.pojo.DTO;


public class UpdatePasswordDTO {
	Integer userId;
	String password;
	String newPassword;
	String passwordAgain;

	public UpdatePasswordDTO() {}

	public UpdatePasswordDTO(Integer userId, String password, String newPassword, String passwordAgain) {
		this.userId = userId;
		this.password = password;
		this.newPassword = newPassword;
		this.passwordAgain = passwordAgain;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
}
