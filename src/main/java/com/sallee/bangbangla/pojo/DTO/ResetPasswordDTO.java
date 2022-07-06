package com.sallee.bangbangla.pojo.DTO;


public class ResetPasswordDTO {
	String tel;
	String captcha;
	String password;
	String passwordAgain;

	public ResetPasswordDTO() {}

	public ResetPasswordDTO(String tel, String captcha, String password, String passwordAgain) {
		this.tel = tel;
		this.captcha = captcha;
		this.password = password;
		this.passwordAgain = passwordAgain;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
}
