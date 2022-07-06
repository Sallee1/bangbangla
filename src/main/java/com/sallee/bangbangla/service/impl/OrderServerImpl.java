package com.sallee.bangbangla.service.impl;


import com.sallee.bangbangla.mapper.*;
import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.VO.UserCreditVO;
import com.sallee.bangbangla.service.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return false;
	}

	@Override
	public UserCreditVO selectAllBuyer(Integer itemId) {
		return null;
	}

	@Override
	public Integer chooseBuyer(UserItemRelateDTO userItemRelateDTO) {
		return null;
	}

	@Override
	public boolean pay(Integer orderId) {
		return false;
	}

	@Override
	public boolean finishOrder(Integer orderId) {
		return false;
	}

	@Override
	public boolean moveToHistory(Integer orderId) {
		return false;
	}
}
