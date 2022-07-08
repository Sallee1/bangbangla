package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.*;
import com.sallee.bangbangla.pojo.DAO.*;
import com.sallee.bangbangla.pojo.DTO.OrderDTO;
import com.sallee.bangbangla.pojo.VO.UserCreditVO;
import com.sallee.bangbangla.service.OrderServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServerImpl implements OrderServer {
	@Autowired
	public ItemMapper itemMapper;
	@Autowired
	public OrderHistoryMapper orderHistoryMapper;
	@Autowired
	public OrderMapper orderMapper;
	@Autowired
	public UserMapper userMapper;
	@Autowired
	public ItemHistoryMapper itemHistoryMapper;

	@Override
	public boolean addWant(OrderDTO  orderDTO) {
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.setBuyerId(orderDTO.getBuyerId());
		orderDAO.setItemId(orderDTO.getItemId());
		//检测订单是否写过
		QueryWrapper wrapper = new QueryWrapper();
		wrapper.eq("item_id",orderDTO.getItemId());
		wrapper.eq("buyer_id",orderDAO.getBuyerId());
		if(orderMapper.selectOne(wrapper) != null)
			throw new RuntimeException("ORDER_ALREADY_EXIST");
		//将订单信息加入 用户-物品映射表
		if (orderMapper.insert(orderDAO) > 0){
			return true;
		}
		else{
			throw new RuntimeException("ADDWANT_FAIL");
		}
	}

	@Override
	public List<UserCreditVO> selectAllBuyer(Integer itemId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("item_id",itemId);
		List<UserCreditVO> buyerList = orderMapper.selectList(queryWrapper);
		return buyerList;
	}

	@Override
	public Integer chooseBuyer(OrderDTO orderDTO) {
		ItemDAO itemDAO = itemMapper.selectById(orderDTO.getItemId());

		//指定buyer
		itemDAO.setBuyerId(orderDTO.getBuyerId());

//		根据item交易类型来决定谁付钱
		if(itemDAO.getMainLabel() == 0){
			itemDAO.setPayState(0);
		}else{
			itemDAO.setPayState(1);
		}
		//设订单状态为等待支付
		itemDAO.setState(1);
		//更新数据库item表数据
		if (itemMapper.updateById(itemDAO) == 0){
			throw new RuntimeException("ITEM_UPDATE_FAIL");
		}
		return itemDAO.getId();
	}


	@Override
	public boolean pay(Integer itemId) {
		ItemDAO itemDAO = itemMapper.selectById(itemId);

		Integer payerId;

		if(itemDAO.getState() == 0){
			payerId = itemDAO.getBuyerId();
		}else {
			payerId = itemDAO.getSellerId();
		}

		UserDAO userDAO = userMapper.selectById(payerId);

		if(userDAO.getScore() >= itemDAO.getPrice()){
			//扣去payer的钱
			userDAO.setScore(userDAO.getScore() - itemDAO.getPrice());
			if (userMapper.updateById(userDAO) == 0){
				throw new RuntimeException("USER_UPDATE_FAIL");
			}

			//更改订单状态为处理中
			itemDAO.setPayState(2);
			if (itemMapper.updateById(itemDAO) == 0){
				throw new RuntimeException("ITEM_UPDATE_FAIL");
			}
			return true;
		}else {
			throw new RuntimeException("SCORE_NOT_ENOUGH");
		}

	}

	@Override
	public boolean finishOrder(Integer orderId) {
		OrderDAO orderDAO = orderMapper.selectById(orderId);
		Integer itemId = orderDAO.getItemId();
		ItemDAO itemDAO = itemMapper.selectById(itemId);

		//查找收钱人的信息

		Integer bePayerId;
		if(itemDAO.getState() == 1){
			bePayerId = itemDAO.getSellerId();

		}else {
			bePayerId = itemDAO.getBuyerId();
		}
		UserDAO userDAO = userMapper.selectById(bePayerId);

		//给bePayerId加上item的价格
		userDAO.setScore(userDAO.getScore() + itemDAO.getPrice());
		if (userMapper.updateById(userDAO) == 0){
			throw new RuntimeException("USER_UPDATE_FAIL");
		}

		//将订单移入Order_History表
		OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
		BeanUtils.copyProperties(orderDAO,orderHistoryDAO);

		//1.先添加数据
		if (orderHistoryMapper.insert(orderHistoryDAO) == 0){
			throw new RuntimeException("ITEM_UPDATE_FAIL");
		}else {
			//2.添加成功再删除Order表中的数据
			if (orderMapper.deleteById(orderDAO) == 0)
				throw new RuntimeException("ORDER_DELETE_FAIL");
		}

		//更改订单状态为完成
		itemDAO.setPayState(3);
		//将item移入Item_History表
		ItemHistoryDAO itemHistoryDAO = new ItemHistoryDAO();
		BeanUtils.copyProperties(itemDAO,itemHistoryDAO);

		//1.先将item插入入item_history表
		if (itemHistoryMapper.insert(itemHistoryDAO) == 0){
			throw new RuntimeException("ITEMHISTORY_UPDATE_FAIL");
		}else{
			//2.插入成功后再删掉item表中的item
			if (itemMapper.deleteById(itemDAO) == 0)
				throw new RuntimeException("ITEMHISTORY_DELETE_FAIL");
		}

		return true;

	}

	@Override
	public boolean moveToHistory(Integer orderId) {
		OrderDAO orderDAO = orderMapper.selectById(orderId);
		Integer itemId = orderDAO.getItemId();
		ItemDAO itemDAO = itemMapper.selectById(itemId);

		//将 用户-订单表 移入Order_History表
		OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
		BeanUtils.copyProperties(orderDAO,orderHistoryDAO);

		//1.先添加数据
		if (orderHistoryMapper.insert(orderHistoryDAO) == 0){
			throw new RuntimeException("ITEM_UPDATE_FAIL");
		}else {
			//2.添加成功再删除Order表中的数据
			if (orderMapper.deleteById(orderDAO) == 0)
				throw new RuntimeException("ORDER_DELETE_FAIL");
		}

		//更改订单状态为完成
		itemDAO.setPayState(3);
		//将item移入Item_History表
		ItemHistoryDAO itemHistoryDAO = new ItemHistoryDAO();
		BeanUtils.copyProperties(itemDAO,itemHistoryDAO);

		//1.先将item插入入item_history表
		if (itemHistoryMapper.insert(itemHistoryDAO) == 0){
			throw new RuntimeException("ITEMHISTORY_UPDATE_FAIL");
		}else{
			//2.插入成功后再删掉item表中的item
			if (itemMapper.deleteById(itemDAO) == 0)
				throw new RuntimeException("ITEMHISTORY_DELETE_FAIL");
		}

		return false;
	}
}
