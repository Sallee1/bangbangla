package com.sallee.bangbangla.pojo.DAO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("admins")
public class AdminDAO {
	@TableId(type = IdType.AUTO)
	Integer id;
	String userName;
	String password;
	String salt;

	public AdminDAO(){};

	public AdminDAO(Integer id, String userName, String password, String salt) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.salt = salt;
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
}
