package com.sallee.bangbangla.service.impl;


import com.sallee.bangbangla.mapper.UserMapper;
import com.sallee.bangbangla.pojo.DTO.EditInfoDTO;
import com.sallee.bangbangla.pojo.DTO.LoginDTO;
import com.sallee.bangbangla.pojo.DTO.RegisterDTO;
import com.sallee.bangbangla.pojo.DTO.ResetPasswordDTO;
import com.sallee.bangbangla.pojo.DTO.UpdatePasswordDTO;
import com.sallee.bangbangla.pojo.DTO.UserBriefInfoDTO;
import com.sallee.bangbangla.pojo.VO.UserInfoVO;
import com.sallee.bangbangla.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements UserServer {
	@Autowired
	public UserMapper userMapper;

	@Override
	public UserBriefInfoDTO login(LoginDTO loginDTO) {
		return null;
	}

	@Override
	public UserBriefInfoDTO register(RegisterDTO register) {
		return null;
	}

	@Override
	public UserInfoVO getInfo(Integer userId) {
		return null;
	}

	@Override
	public boolean editInfo(EditInfoDTO editInfoDTO) {
		return false;
	}

	@Override
	public boolean resetPassword(ResetPasswordDTO resetPasswordDTO) {
		return false;
	}

	@Override
	public boolean updataPassword(UpdatePasswordDTO updataPasswordDTO) {
		return false;
	}
}
