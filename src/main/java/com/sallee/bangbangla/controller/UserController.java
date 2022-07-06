package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.EditInfoDTO;
import com.sallee.bangbangla.pojo.DTO.LoginDTO;
import com.sallee.bangbangla.pojo.DTO.RegisterDTO;
import com.sallee.bangbangla.pojo.DTO.ResetPasswordDTO;
import com.sallee.bangbangla.pojo.DTO.UpdatePasswordDTO;
import com.sallee.bangbangla.pojo.ServerResult;
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

		return null;
	}

	@RequestMapping("/user/register")
	public ServerResult register(RegisterDTO register) {

		return null;
	}

	@RequestMapping("/user/info")
	public ServerResult getInfo(Integer userId) {

		return null;
	}

	@RequestMapping("/user/editInfo")
	public ServerResult editInfo(EditInfoDTO editInfoDTO) {

		return null;
	}

	@RequestMapping("/user/resetPassword")
	public ServerResult resetPassword(ResetPasswordDTO resetPasswordDTO) {

		return null;
	}

	@RequestMapping("/user/updatePassword")
	public ServerResult updatePassword(UpdatePasswordDTO updatePasswordDTO) {

		return null;
	}
}
