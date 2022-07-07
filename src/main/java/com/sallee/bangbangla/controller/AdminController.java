package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.BanUserDTO;
import com.sallee.bangbangla.pojo.DTO.LoginDTO;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.pojo.VO.AdminOrderVO;
import com.sallee.bangbangla.service.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	public AdminServer adminServer;

	@RequestMapping("/admin/login")
	public ServerResult login(LoginDTO loginDTO) {
		Integer id =  adminServer.login(loginDTO);
		return new ServerResult(0,"登录成功",id);
	}

	@RequestMapping("/admin/item")
	public ServerResult selectItemsWithId(Integer itemId) {
		AdminOrderVO adminOrderVO = adminServer.selectItemsWithId(itemId);
		return new ServerResult(0,"查找成功",adminOrderVO);
	}

	@RequestMapping("/admin/allOrder")
	public ServerResult selectAllOrder() {

		return null;
	}

	@RequestMapping("/admin/removeItem")
	public ServerResult removeItem(Integer itemId) {

		return null;
	}

	@RequestMapping("/admin/username")
	public ServerResult selectUserWithName(String userName) {

		return null;
	}

	@RequestMapping("/admin/userid")
	public ServerResult selectUserWithId(String userId) {

		return null;
	}

	@RequestMapping("/admin/allUser")
	public ServerResult selectAllUser() {

		return null;
	}

	@RequestMapping("/admin/ban")
	public ServerResult banId(BanUserDTO banUserDTO) {

		return null;
	}

	@RequestMapping("/admin/allReport")
	public ServerResult selectAllReport() {

		return null;
	}
	@RequestMapping("/admin/removeReport")
	public ServerResult removeReport(Integer reportId) {

		return null;
	}
	@RequestMapping("/admin/allBan")
	public ServerResult selectAllBan() {

		return null;
	}
}
