package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.*;
import com.sallee.bangbangla.pojo.DAO.AdminDAO;
import com.sallee.bangbangla.pojo.DAO.BanDAO;
import com.sallee.bangbangla.pojo.DTO.BanUserDTO;
import com.sallee.bangbangla.pojo.DTO.LoginDTO;
import com.sallee.bangbangla.pojo.VO.AdminOrderVO;
import com.sallee.bangbangla.pojo.VO.AdminReportVO;
import com.sallee.bangbangla.pojo.VO.AdminUserVO;
import com.sallee.bangbangla.service.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServerImpl implements AdminServer {
	@Autowired
	public UserMapper userMapper;
	@Autowired
	public ItemMapper itemMapper;
	@Autowired
	public OrderMapper orderMapper;
	@Autowired
	public OrderHistoryMapper orderHistoryMapper;
	@Autowired
	public AdminMapper adminMapper;
	@Autowired
	public BanMapper banMapper;


	@Override
	public Integer login(LoginDTO loginDTO) {
		//从数据库查询管理员是否存在
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("user_name",loginDTO.getUserName());
		AdminDAO admin = adminMapper.selectOne(queryWrapper);
		if(admin == null)throw new RuntimeException("ADMIN_USER_NOT_EXIST");

		if(admin.getPassword().equals(StaticTool.getSHA256(loginDTO.getPassword()+admin.getSalt())))
			return  admin.getId();
		throw new RuntimeException("ADMIN_PASSWORD_ERROR");
	}

	@Override
	public AdminOrderVO selectItemsWithId(Integer itemId) {
		return null;
	}

	@Override
	public List<AdminOrderVO> selectAllOrder() {
		return null;
	}

	@Override
	public boolean removeItem(Integer itemId) {
		return false;
	}

	@Override
	public AdminUserVO selectUserWithName(String userName) {
		return null;
	}

	@Override
	public AdminUserVO selectUserWithId(String userId) {
		return null;
	}

	@Override
	public List<AdminUserVO> selectAllUser() {
		return null;
	}

	@Override
	public boolean banId(BanUserDTO banUserDTO) {
		return false;
	}

	@Override
	public AdminReportVO selectAllReport() {
		return null;
	}

	@Override
	public boolean removeReport(Integer reportId) {
		return false;
	}

	@Override
	public BanDAO selectAllBan() {
		return null;
	}
}
