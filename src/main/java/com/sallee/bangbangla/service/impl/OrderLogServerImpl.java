package com.sallee.bangbangla.service.impl;


import com.sallee.bangbangla.mapper.ItemMapper;
import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.VO.OrderLogDetailVO;
import com.sallee.bangbangla.pojo.VO.OrderLogVO;
import com.sallee.bangbangla.service.OrderLogServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderLogServerImpl implements OrderLogServer {

	@Autowired
	public ItemMapper itemMapper;

	@Override
	public List<OrderLogVO> showOrderFrom(Integer userId) {
		return null;
	}

	@Override
	public List<OrderLogVO> showOrderTo(Integer userId) {
		return null;
	}

	@Override
	public OrderLogDetailVO showOrderDetail(UserItemRelateDTO userItemRelateDTO) {
		return null;
	}
}
