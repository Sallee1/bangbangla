package com.sallee.bangbangla.service.impl;


import com.sallee.bangbangla.mapper.BanMapper;
import com.sallee.bangbangla.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class StaticCheck {
	@Autowired
	public BanMapper banMapper;
	@Autowired
	public UserMapper userMapper;
	public static boolean userIsBan(Integer userId) {

		return false;
	}

	public static boolean userIsLogin(Integer userId) {

		return false;
	}
}
