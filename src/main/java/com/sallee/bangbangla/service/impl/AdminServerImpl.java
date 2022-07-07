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

		//拼接买家用户名
		Integer buyerId=null,sellId=null;
		Date dealTime = null;
		if(isOld)
		{
			buyerId = hisItem.getBuyerId();
			sellId = hisItem.getSellerId();
			dealTime = hisItem.getDealTime();
		}
		else
		{
			QueryWrapper orderQueryWrapper = new QueryWrapper();
			orderQueryWrapper.eq("item_id",itemId);
			OrderDAO order = orderMapper.selectOne(orderQueryWrapper);
			if(order != null) {
				buyerId = order.getBuyerId();
				dealTime = order.getDealTime();
			}
			sellId=item.getSellerId();
		}

		//装载
		AdminOrderVO adminOrderVO = new AdminOrderVO();
		adminOrderVO.setSellerId(sellId);
		adminOrderVO.setBuyerId(buyerId);
		if(isOld)
		{
			adminOrderVO.setCreateTime(hisItem.getCreateTime());
			adminOrderVO.setDealTime(dealTime);
			adminOrderVO.setFinishTime(hisItem.getFinishTime());
			adminOrderVO.setState(Enum.OrderState.values()[hisItem.getState()].toString());
			adminOrderVO.setTitle(hisItem.getTitle());
			adminOrderVO.setIntroduce(hisItem.getIntroduce());
			adminOrderVO.setPrice(hisItem.getPrice());
			adminOrderVO.setImagePaths(hisItem.getImagePaths());
			adminOrderVO.setMainLabel(Enum.OrderState.values()[hisItem.getState()].toString());
			adminOrderVO.setSubLabel(hisItem.getSubLabel());
			adminOrderVO.setCommit(hisItem.getCommit());
			adminOrderVO.setCredit(hisItem.getCredit());
		}else
		{
			adminOrderVO.setCreateTime(item.getCreateTime());
			adminOrderVO.setDealTime(dealTime);
			adminOrderVO.setState(Enum.OrderState.values()[item.getState()].toString());
			adminOrderVO.setTitle(item.getTitle());
			adminOrderVO.setIntroduce(item.getIntroduce());
			adminOrderVO.setPrice(item.getPrice());
			adminOrderVO.setImagePaths(item.getImagePaths());
			adminOrderVO.setMainLabel(Enum.OrderState.values()[item.getState()].toString());
			adminOrderVO.setSubLabel(item.getSubLabel());
		}

		return adminOrderVO;
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
