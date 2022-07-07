package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.*;
import com.sallee.bangbangla.pojo.DAO.*;
import com.sallee.bangbangla.pojo.DTO.BanUserDTO;
import com.sallee.bangbangla.pojo.DTO.LoginDTO;
import com.sallee.bangbangla.pojo.VO.AdminOrderVO;
import com.sallee.bangbangla.pojo.VO.AdminReportVO;
import com.sallee.bangbangla.pojo.VO.AdminUserVO;
import com.sallee.bangbangla.service.AdminServer;
import com.sallee.bangbangla.pojo.Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
	@Autowired
	public UserItemRelateMapper userItemRelateMapper;
	@Autowired
	public UserItemRelateHistoryMapper userItemRelateHistoryMapper;


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
		boolean isOld = false;
		//从订单列表查询
		QueryWrapper itemQueryWrapper = new QueryWrapper();
		itemQueryWrapper.eq("id",itemId);
		ItemDAO item = itemMapper.selectOne(itemQueryWrapper);

		//如果找不到，从历史订单找
		OrderHistoryDAO hisItem = null;
		if(item == null)
		{
			QueryWrapper hisItemQueryWrapper = new QueryWrapper();
			hisItemQueryWrapper.eq("id",itemId);

			hisItem = orderHistoryMapper.selectOne(hisItemQueryWrapper);
			if(hisItem == null) throw new RuntimeException("ADMIN_ITEM_NOT_EXIST");
			isOld = true;
		}

		//装载
		AdminOrderVO adminOrderVO;
		if(isOld) adminOrderVO = new AdminOrderVO(hisItem);
		else adminOrderVO = new AdminOrderVO(item,orderMapper);
		return adminOrderVO;
	}

	@Override
	public List<AdminOrderVO> selectAllOrder() {
		//查询所有的订单表和历史订单表
		List<ItemDAO> items = itemMapper.selectList(null);
		List<OrderHistoryDAO> orderHistoryDAOS = orderHistoryMapper.selectList(null);
		//复制到AdminOrderVO
		List<AdminOrderVO> adminOrderVOList = new ArrayList<>();
		for(ItemDAO item:items) {
			AdminOrderVO adminOrderVO = new AdminOrderVO(item,orderMapper);
			adminOrderVOList.add(adminOrderVO);
		}
		for(OrderHistoryDAO hisItems:orderHistoryDAOS)
		{
			AdminOrderVO adminOrderVO = new AdminOrderVO(hisItems);
			adminOrderVOList.add(adminOrderVO);
		}
		return adminOrderVOList;
	}

	@Override
	public boolean removeItem(Integer itemId) {
		boolean isOld = false;
		//从订单列表查询
		QueryWrapper itemQueryWrapper = new QueryWrapper();
		itemQueryWrapper.eq("id",itemId);
		ItemDAO item = itemMapper.selectOne(itemQueryWrapper);

		//如果找不到，从历史订单找
		OrderHistoryDAO hisItem;
		QueryWrapper hisItemQueryWrapper = null;
		if(item == null)
		{
			hisItemQueryWrapper = new QueryWrapper();
			hisItemQueryWrapper.eq("id",itemId);

			hisItem = orderHistoryMapper.selectOne(hisItemQueryWrapper);
			if(hisItem == null) throw new RuntimeException("ADMIN_ITEM_NOT_EXIST");
			isOld = true;
		}

		//移除对应的订单
		if(isOld)
		{
			orderHistoryMapper.delete(hisItemQueryWrapper);
			QueryWrapper userItemHisQueryWrapper = new QueryWrapper();
			userItemHisQueryWrapper.eq("item_id",itemId);
			userItemRelateHistoryMapper.delete(userItemHisQueryWrapper);
		}
		else
		{
			itemMapper.delete(itemQueryWrapper);
			QueryWrapper orderQueryWrapper = new QueryWrapper();
			orderQueryWrapper.eq("item_id",itemId);
			userItemRelateMapper.delete(orderQueryWrapper);
			orderMapper.delete(orderQueryWrapper);
		}
		return true;
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
