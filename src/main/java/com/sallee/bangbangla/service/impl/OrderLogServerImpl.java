package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.ItemHistoryMapper;
import com.sallee.bangbangla.mapper.ItemMapper;
import com.sallee.bangbangla.mapper.OrderHistoryMapper;
import com.sallee.bangbangla.mapper.OrderMapper;
import com.sallee.bangbangla.pojo.DAO.ItemDAO;
import com.sallee.bangbangla.pojo.DAO.ItemHistoryDAO;
import com.sallee.bangbangla.pojo.DAO.OrderDAO;
import com.sallee.bangbangla.pojo.DAO.OrderHistoryDAO;
import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.Enum;
import com.sallee.bangbangla.pojo.VO.AdminOrderVO;
import com.sallee.bangbangla.pojo.VO.OrderLogDetailVO;
import com.sallee.bangbangla.pojo.VO.OrderLogVO;
import com.sallee.bangbangla.service.AdminServer;
import com.sallee.bangbangla.service.ItemServer;
import com.sallee.bangbangla.service.OrderLogServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderLogServerImpl implements OrderLogServer {

	@Autowired
	public ItemMapper itemMapper;
	@Autowired
	public ItemHistoryMapper itemHistoryMapper;
	@Autowired
	public OrderMapper orderMapper;
	@Autowired
	public OrderHistoryMapper orderHistoryMapper;

	@Autowired
	public AdminServer adminServer;

	@Override
	public List<OrderLogVO> showOrderFrom(Integer userId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		//查订单表
		queryWrapper.eq("seller_id",userId);
		List<ItemDAO> itemList = itemMapper.selectList(queryWrapper);
		//查历史订单表
		List<ItemHistoryDAO> hisItemList = itemHistoryMapper.selectList(queryWrapper);

		//装载
		List<OrderLogVO> orderLogVOS = new ArrayList<>();
		for(ItemDAO itemDAO:itemList) {
			OrderLogVO temp = new OrderLogVO();
			temp.setOrderId(itemDAO.getId());
			temp.setCreateTime(StaticTool.date2String(itemDAO.getCreateTime()));
			temp.setState(Enum.OrderState.values()[itemDAO.getState()].toString());
			temp.setTitle(itemDAO.getTitle());
			orderLogVOS.add(temp);
		}
		for(ItemHistoryDAO itemHistoryDAO:hisItemList) {
			OrderLogVO temp = new OrderLogVO();
			temp.setOrderId(itemHistoryDAO.getId());
			temp.setCreateTime(StaticTool.date2String(itemHistoryDAO.getCreateTime()));
			temp.setState(Enum.OrderState.values()[itemHistoryDAO.getState()].toString());
			temp.setTitle(itemHistoryDAO.getTitle());
			orderLogVOS.add(temp);
		}
		return orderLogVOS;
	}

	@Override
	public List<OrderLogVO> showOrderTo(Integer userId) {
		//查现有订单集合
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("buyer_id",userId);
		List<OrderDAO> orders = orderMapper.selectList(queryWrapper);
		//查历史订单集合
		List<OrderHistoryDAO> hisOrders = orderHistoryMapper.selectList(queryWrapper);
		//根据现有订单查询需求表
		List<OrderLogVO> orderLogVOS = new ArrayList<>();
		for(OrderDAO orderDAO:orders)
		{
			OrderLogVO temp = new OrderLogVO();
			AdminOrderVO item = adminServer.selectItemsWithId(orderDAO.getItemId());

			temp.setTitle(item.getTitle());
			temp.setCreateTime(StaticTool.date2String(item.getCreateTime()));
			temp.setOrderId(item.getId());
			if(item.getBuyerId() != null && item.getBuyerId() != userId)	 //订单不是自己的
				temp.setState("CANCEL");
			else
				temp.setState(item.getState());		//订单是自己的
			orderLogVOS.add(temp);
		}

		for(OrderHistoryDAO orderHistoryDAO:hisOrders)
		{
			OrderLogVO temp = new OrderLogVO();
			AdminOrderVO item = adminServer.selectItemsWithId(orderHistoryDAO.getItemId());

			temp.setTitle(item.getTitle());
			temp.setCreateTime(StaticTool.date2String(item.getCreateTime()));
			temp.setOrderId(item.getId());
			if(item.getBuyerId() != null && item.getBuyerId() != userId)	 //订单不是自己的
				temp.setState("CANCEL");
			else
				temp.setState(item.getState());		//订单是自己的
			orderLogVOS.add(temp);
		}
		return orderLogVOS;
	}

	@Override
	public OrderLogDetailVO showOrderDetail(UserItemRelateDTO userItemRelateDTO) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",userItemRelateDTO.getItemId());
		//查询现存订单
		ItemDAO item = itemMapper.selectOne(queryWrapper);
		OrderLogDetailVO orderLogDetailVO;
		ItemHistoryDAO hisItem = itemHistoryMapper.selectOne(queryWrapper);
		if(item != null)
		{
			orderLogDetailVO = new OrderLogDetailVO();
			orderLogDetailVO.setOrderId(item.getId());
			orderLogDetailVO.setCreateTime(StaticTool.date2String(item.getCreateTime()));
			orderLogDetailVO.setIntroduce(item.getIntroduce());
			if (item.getSellerId() == userItemRelateDTO.getUserId() ||
							item.getBuyerId() == userItemRelateDTO.getUserId() ||
							item.getBuyerId() == null)    //订单未失效
				orderLogDetailVO.setState(Enum.OrderState.values()[item.getState()].toString());
			else
				orderLogDetailVO.setState("CANCEL");
			orderLogDetailVO.setPayState(Enum.OrderState.values()[item.getPayState()].toString());
			orderLogDetailVO.setMainLabel(Enum.MainLabel.values()[item.getMainLabel()].toString());
			orderLogDetailVO.setSubLabel(item.getSubLabel());
			orderLogDetailVO.setTitle(item.getTitle());
			orderLogDetailVO.setScore(item.getPrice());
		}
		else if(hisItem != null)
		{
			orderLogDetailVO = new OrderLogDetailVO();
			orderLogDetailVO.setOrderId(hisItem.getId());
			orderLogDetailVO.setCreateTime(StaticTool.date2String(hisItem.getCreateTime()));
			orderLogDetailVO.setIntroduce(hisItem.getIntroduce());
			if (hisItem.getSellerId() == userItemRelateDTO.getUserId() ||
							hisItem.getBuyerId() == userItemRelateDTO.getUserId() ||
							hisItem.getBuyerId() == null)    //订单未失效
				orderLogDetailVO.setState(Enum.OrderState.values()[hisItem.getState()].toString());
			else
				orderLogDetailVO.setState("CANCEL");
			orderLogDetailVO.setPayState(Enum.OrderState.values()[hisItem.getPayState()].toString());
			orderLogDetailVO.setMainLabel(Enum.MainLabel.values()[hisItem.getMainLabel()].toString());
			orderLogDetailVO.setSubLabel(hisItem.getSubLabel());
			orderLogDetailVO.setTitle(hisItem.getTitle());
			orderLogDetailVO.setScore(hisItem.getPrice());
		}
		else throw new RuntimeException("ITEM_NOT_EXIST");
		return orderLogDetailVO;
	}
}
