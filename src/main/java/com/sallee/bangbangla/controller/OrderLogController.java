package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.pojo.VO.OrderLogDetailVO;
import com.sallee.bangbangla.pojo.VO.OrderLogVO;
import com.sallee.bangbangla.service.OrderLogServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class OrderLogController {
	@Autowired
	public OrderLogServer orderLogServer;

	@RequestMapping("/orderLog/form")
	public ServerResult showOrderFrom(Integer userId) {
		List<OrderLogVO> orders = orderLogServer.showOrderFrom(userId);
		return new ServerResult(0,"查询成功",orders);
	}

	@RequestMapping("/orderLog/to")
	public ServerResult showOrderTo(Integer userId) {
		List<OrderLogVO> orders = orderLogServer.showOrderTo(userId);
		return new ServerResult(0,"查询成功",orders);
	}

	@RequestMapping("/orderLog/detail")
	public ServerResult showOrderDetail(UserItemRelateDTO userItemRelateDTO) {
		OrderLogDetailVO orderLogDetailVO = orderLogServer.showOrderDetail(userItemRelateDTO);
		return new ServerResult(0,"查询成功",orderLogDetailVO);
	}
}
