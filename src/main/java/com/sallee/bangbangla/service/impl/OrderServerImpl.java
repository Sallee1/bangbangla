package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.*;
import com.sallee.bangbangla.pojo.DAO.ItemDAO;
import com.sallee.bangbangla.pojo.DAO.OrderDAO;
import com.sallee.bangbangla.pojo.DAO.UserItemRelateDAO;
import com.sallee.bangbangla.pojo.DTO.OrderDTO;
import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.VO.UserCreditVO;
import com.sallee.bangbangla.service.OrderServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
		UserItemRelateDAO userItemRelateDAO = new UserItemRelateDAO();
		BeanUtils.copyProperties(userItemRelateDTO,userItemRelateDAO);
		int insertRow = userItemRelateMapper.insert(userItemRelateDAO);
		if (insertRow > 0){
			return true;
		}
		else{
			throw new RuntimeException();
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
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("item_id",orderDTO.getItemId());
		ItemDAO itemDAO = itemMapper.selectById(queryWrapper);

		//根据item交易类型来决定谁付钱
		if(itemDAO.getMainLabel() == 0){
			orderDAO.setPayState(0);
		}else{
			orderDAO.setPayState(1);
		}
		//设订单状态为等待支付
		itemDAO.setState(0);


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
