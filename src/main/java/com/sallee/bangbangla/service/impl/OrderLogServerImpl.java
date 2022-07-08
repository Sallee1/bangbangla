package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("sellerID",userId);
		List<OrderLogVO> list = itemMapper.selectList(queryWrapper);
		return list;
	}

	@Override
	public List<OrderLogVO> showOrderTo(Integer userId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("buyerID",userId);
		List<OrderLogVO> list = itemMapper.selectList(queryWrapper);
		return list;
	}

	@Override
	public OrderLogDetailVO showOrderDetail(UserItemRelateDTO userItemRelateDTO) {
		
		return null;
	}
}
