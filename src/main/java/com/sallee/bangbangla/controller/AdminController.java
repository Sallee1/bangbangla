package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DAO.BanDAO;
import com.sallee.bangbangla.pojo.DTO.BanUserDTO;
import com.sallee.bangbangla.pojo.DTO.LoginDTO;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.pojo.VO.AdminOrderVO;
import com.sallee.bangbangla.pojo.VO.AdminReportVO;
import com.sallee.bangbangla.pojo.VO.AdminUserVO;
import com.sallee.bangbangla.service.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
		List<AdminOrderVO> adminOrderVOList = adminServer.selectAllOrder();
		return new ServerResult(0,"查找成功",adminOrderVOList);
	}

	@RequestMapping("/admin/removeItem")
	public ServerResult removeItem(Integer itemId) {
		boolean isSuccess = adminServer.removeItem(itemId);
		return new ServerResult(0,"删除成功",isSuccess);
	}

	@RequestMapping("/admin/userid")
	public ServerResult selectUserWithId(Integer userId) {
		AdminUserVO userVO = adminServer.selectUserWithId(userId);
		return new ServerResult(0,"查找成功",userVO);
	}

	@RequestMapping("/admin/allUser")
	public ServerResult selectAllUser() {
		List<AdminUserVO> adminUserVOList = adminServer.selectAllUser();
		return new ServerResult(0,"查找成功",adminUserVOList);
	}

	@RequestMapping("/admin/ban")
	public ServerResult banId(BanUserDTO banUserDTO) {
		boolean isSuccess = adminServer.banId(banUserDTO);
		return new ServerResult(0,"封禁成功",isSuccess);
	}

	@RequestMapping("/admin/allReport")
	public ServerResult selectAllReport() {
		List<AdminReportVO> adminReportVOList = adminServer.selectAllReport();
		return new ServerResult(0,"查找成功",adminReportVOList);
	}
	@RequestMapping("/admin/removeReport")
	public ServerResult removeReport(Integer reportId) {
		boolean isSuccess = adminServer.removeReport(reportId);
		return new ServerResult(0,"删除成功",isSuccess);
	}
	@RequestMapping("/admin/allBan")
	public ServerResult selectAllBan() {
		List<BanDAO> banDAOList = adminServer.selectAllBan();
		return new ServerResult(0,"查找成功",banDAOList);
	}
}
