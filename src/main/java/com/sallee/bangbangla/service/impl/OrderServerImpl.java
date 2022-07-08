package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.*;
import com.sallee.bangbangla.pojo.DAO.*;
import com.sallee.bangbangla.pojo.DTO.OrderDTO;
import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
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
	public OrderMapper orderMapper;
	@Autowired
	public UserMapper userMapper;
	@Autowired
	public UserItemRelateMapper userItemRelateMapper;
	@Autowired
	public UserItemRelateHistoryMapper userItemRelateHistoryMapper;
	@Autowired
	public OrderHistoryMapper orderHistoryMapper;

	@Override
	public boolean addWant(UserItemRelateDTO userItemRelateDTO) {
		OrderDAO orderDAO = new OrderDAO();
		BeanUtils.copyProperties(userItemRelateDTO, orderDAO);
		int insertRow = userItemRelateMapper.insert(orderDAO);
		if (insertRow > 0){
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
		List<UserCreditVO> daoList = userItemRelateMapper.selectList(queryWrapper);
		return daoList;
	}

	@Override
	public Integer chooseBuyer(UserItemRelateDTO userItemRelateDTO) {


		return null;
	}

	@Override
	public Integer createOrder(OrderDTO orderDTO) {
		OrderDAO orderDAO = new OrderDAO();
		BeanUtils.copyProperties(orderDTO,orderDAO);
		ItemDAO itemDAO = itemMapper.selectById(orderDTO.getItemId());

		//根据item交易类型来决定谁付钱
		if(itemDAO.getMainLabel() == 0){
			orderDAO.setPayState(0);
		}else{
			orderDAO.setPayState(1);
		}
		//设订单状态为等待支付
		itemDAO.setState(0);
		//订单创建时间留空，让数据库自动填写

		return orderDAO.getId();
	}

	@Override
	public boolean pay(Integer orderId) {
		OrderDAO orderDAO = orderMapper.selectById(orderId);
		ItemDAO itemDAO = itemMapper.selectById(orderDAO.getItemId());

		Integer payerId;
		if(orderDAO.getState() == 0){
			payerId = orderDAO.getBuyerId();
		}else {
			payerId = orderDAO.getSellerId();
		}

		UserDAO userDAO = userMapper.selectById(payerId);

		if(userDAO.getScore() >= itemDAO.getPrice()){
			//扣去payer的钱
			userDAO.setScore(userDAO.getScore() - itemDAO.getPrice());
			if (userMapper.updateById(userDAO) == 0){
				throw new RuntimeException("USER_UPDATE_FAIL");
			}

			//更改订单状态为处理中
			orderDAO.setPayState(2);
			if (orderMapper.updateById(orderDAO) == 0){
				throw new RuntimeException("ORDER_UPDATE_FAIL");
			}
			return true;
		}else {
			throw new RuntimeException("SCORE_NOT_ENOUGH");
		}

	}

	@Override
	public boolean finishOrder(Integer orderId) {
		OrderDAO orderDAO = orderMapper.selectById(orderId);
		ItemDAO itemDAO = itemMapper.selectById(orderDAO.getItemId());

		//查找收钱人的信息
		Integer sellerId;
		if(orderDAO.getState() == 0){
			sellerId = orderDAO.getSellerId();
		}else {
			sellerId = orderDAO.getBuyerId();
		}
		UserDAO userDAO = userMapper.selectById(sellerId);


		//给seller加上item的价格
		userDAO.setScore(userDAO.getScore() - itemDAO.getPrice());
		if (userMapper.updateById(userDAO) == 0){
			throw new RuntimeException("USER_UPDATE_FAIL");
		}

		//更改订单状态为完成
		orderDAO.setPayState(2);
		//将订单移入Order_History表
		OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();

		return true;

	}

	@Override
	public boolean moveToHistory(Integer orderId) {
		return false;
	}
}
