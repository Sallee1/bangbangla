package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.UserMapper;
import com.sallee.bangbangla.pojo.DAO.UserDAO;
import com.sallee.bangbangla.pojo.DTO.EditInfoDTO;
import com.sallee.bangbangla.pojo.DTO.LoginDTO;
import com.sallee.bangbangla.pojo.DTO.RegisterDTO;
import com.sallee.bangbangla.pojo.DTO.ResetPasswordDTO;
import com.sallee.bangbangla.pojo.DTO.UpdatePasswordDTO;
import com.sallee.bangbangla.pojo.DTO.UserBriefInfoDTO;
import com.sallee.bangbangla.pojo.Enum;
import com.sallee.bangbangla.pojo.VO.UserInfoVO;
import com.sallee.bangbangla.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.Random;

@Service
public class UserServerImpl implements UserServer {
	@Autowired
	public UserMapper userMapper;

	@Override
	public UserBriefInfoDTO login(LoginDTO loginDTO) {

		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("user_name",loginDTO.getUserName());
		queryWrapper.eq("password",loginDTO.getPassword());

		UserDAO selectUserDAO = userMapper.selectOne(queryWrapper);
		//判断登陆是否成功
		if(selectUserDAO!=null){
			UserBriefInfoDTO userBriefInfoDTO = new UserBriefInfoDTO(selectUserDAO.getId(),selectUserDAO.getUserName(),selectUserDAO.getNickName(),selectUserDAO.getUniversityPos(),selectUserDAO.getUniversityName());
			return userBriefInfoDTO;
		}
//		else{
//			throw new RuntimeException("登陆失败");
//		}
		return null;

	}


	@Override
	public UserBriefInfoDTO register(RegisterDTO register) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("user_name",register.getUserName());

		UserDAO userDAO = userMapper.selectOne(queryWrapper);
		if(userDAO == null){
			if(!register.getPassword().equals(register.getPasswordAgain()))
				throw new RuntimeException("密码输入两次不对");

			//设置基本信息
			UserDAO insertUserDAO = new UserDAO();
			insertUserDAO.setUserName(register.getUserName());
			insertUserDAO.setPassword(register.getPassword());
			insertUserDAO.setSex(Enum.Sex.valueOf(register.getSex()).ordinal());
			insertUserDAO.setNickName(register.getNickName());
			insertUserDAO.setIntroduction(register.getIntroduction());
			insertUserDAO.setRealName(register.getRealName());
			insertUserDAO.setIdCard(register.getIdCard());
			insertUserDAO.setRealTel(register.getRealTel());
			insertUserDAO.setUniversityPos(register.getUniversityPos());
			insertUserDAO.setUniversityName(register.getUniversityName());
			insertUserDAO.setStudentId(register.getStudentId());

			int insertRow = userMapper.insert(insertUserDAO);
			if(insertRow == 0){
				throw new RuntimeException("注册保存数据失败");
			}else{
				QueryWrapper selectQueryWrapper = new QueryWrapper();
				selectQueryWrapper.eq("user_name",register.getUserName());
				selectQueryWrapper.eq("password",register.getPassword());

				UserDAO selectUserDAO = userMapper.selectOne(selectQueryWrapper);


				UserBriefInfoDTO userBriefInfoDTO = new UserBriefInfoDTO(selectUserDAO.getId(),selectUserDAO.getUserName(),selectUserDAO.getNickName(),selectUserDAO.getUniversityPos(),selectUserDAO.getUniversityName());
				return userBriefInfoDTO;

			}

		}
		throw new RuntimeException("注册用户名已经存在");

	}


	@Override
	public UserInfoVO getInfo(Integer userId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",userId);

		UserDAO userDAO = userMapper.selectOne(queryWrapper);
		if(userDAO==null){
			return null;
		}

		UserInfoVO userInfoVO = new UserInfoVO(userId,userDAO.getUserName(),
				Enum.Sex.values()[userDAO.getSex()].toString(),userDAO.getNickName(),
				userDAO.getIntroduction(), userDAO.getRealName(), userDAO.getIdCard(),
				userDAO.getRealTel(), userDAO.getUniversityPos(), userDAO.getUniversityName(),
				userDAO.getStudentId(), userDAO.getScore(), userDAO.getTotalCredit(),
				userDAO.getCreditCount());
		return userInfoVO;

	}

	@Override
	public boolean editInfo(EditInfoDTO editInfoDTO) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",editInfoDTO.getUserId());

		UserDAO userDAO = new UserDAO();
		userDAO.setSex(Enum.Sex.valueOf(editInfoDTO.getSex()).ordinal());
		userDAO.setNickName(editInfoDTO.getNickName());
		userDAO.setIntroduction(editInfoDTO.getIntroduction());

		int editRow = userMapper.update(userDAO,queryWrapper);
		return editRow>=1?true:false;
	}

	@Override
	public boolean resetPassword(ResetPasswordDTO resetPasswordDTO) {
		if(resetPasswordDTO==null){
			throw new RuntimeException("手机号为空");
		}
		else{
			Random r = new Random();
			int i1 = r.nextInt(10);
			if(resetPasswordDTO.getCaptcha()==null)
				throw new RuntimeException("验证码为空");

			if(!resetPasswordDTO.getPassword().equals(resetPasswordDTO.getPasswordAgain()))
				throw new RuntimeException("密码输入两次不对");

			QueryWrapper queryWrapper = new QueryWrapper();
			queryWrapper.eq("real_tel",resetPasswordDTO.getTel());

			UserDAO userDAO = new UserDAO();
			userDAO.setPassword(resetPasswordDTO.getPassword());

			int resetRow = userMapper.update(userDAO,queryWrapper);
			return resetRow>=1?true:false;
		}
	}

	@Override
	public boolean updataPassword(UpdatePasswordDTO updataPasswordDTO) {
		if(!updataPasswordDTO.getNewPassword().equals(updataPasswordDTO.getPasswordAgain()))
			throw new RuntimeException("密码输入两次不对");
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",updataPasswordDTO.getUserId());
		queryWrapper.eq("password",updataPasswordDTO.getPassword());

		UserDAO userDAO = new UserDAO();
		userDAO.setPassword(updataPasswordDTO.getNewPassword());

		int updateRow = userMapper.update(userDAO,queryWrapper);

		return updateRow>=1?true:false;
	}
}
