package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.*;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.pojo.VO.UserInfoVO;
import com.sallee.bangbangla.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class UserController {
	@Autowired
	public UserServer userServer;

	@RequestMapping("/user/login")
	public ServerResult login(LoginDTO loginDTO) {
		UserBriefInfoDTO log = userServer.login(loginDTO);
		if(log!=null){
			return new ServerResult(0,"登录成功",log);
		}
		else{
			return new ServerResult(101,"登录失败",log);
		}
	}

	@RequestMapping("/user/register")
	public ServerResult register(RegisterDTO register) {
		UserBriefInfoDTO infoDTO = userServer.register(register);

		return new ServerResult(0,"注册成功",infoDTO);
	}

	@RequestMapping("/user/info")
	public ServerResult getInfo(Integer userId) {
		UserInfoVO getinfo = userServer.getInfo(userId);

		if(getinfo!=null)
			return new ServerResult(0,"查找成功",getinfo);
		else
			return new ServerResult(1,"查找失败",null);

	}

	@RequestMapping("/user/editInfo")
	public ServerResult editInfo(EditInfoDTO editInfoDTO) {
		boolean edit = userServer.editInfo(editInfoDTO);
		if(edit)
			return new ServerResult(0,"修改信息成功",null);
		else
			return new ServerResult(1,"修改信息失败",null);

	}

	@RequestMapping("/user/resetPassword")
	public ServerResult resetPassword(ResetPasswordDTO resetPasswordDTO) {
		boolean reset = userServer.resetPassword(resetPasswordDTO);
		if(reset)
			return new ServerResult(0,"重置密码成功",reset);
		else
			return new ServerResult(1,"重置密码失败",null);

	}

	@RequestMapping("/user/updatePassword")
	public ServerResult updatePassword(UpdatePasswordDTO updatePasswordDTO) {
		boolean upadateIsSus = userServer.updataPassword(updatePasswordDTO);
		if(upadateIsSus)
			return new ServerResult(0,"修改密码成功",null);
		else
			return new ServerResult(103,"修改密码失败",null);

	}
}
