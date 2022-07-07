package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("users")
public class UserDAO {
	@TableId(type=IdType.AUTO)//设置id主键的值是由数据库自动生成
	Integer id;
	String userName;
	String password;
	String salt;
	Date registerTime;
	Date unBanTime;
	Integer sex;
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

	public UserDAO(){}

	public UserDAO(Integer id, String userName, String password, String salt, Date registerTime, Date unBanTime,
								 Integer sex, String nickName, String introduction, String realName, String idCard, String realTel,
								 String universityPos, String universityName, String studentId, Integer score, Integer totalCredit,
								 Integer creditCount) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.salt = salt;
		this.registerTime = registerTime;
		this.unBanTime = unBanTime;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getUnBanTime() {
		return unBanTime;
	}

	public void setUnBanTime(Date unBanTime) {
		this.unBanTime = unBanTime;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
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
