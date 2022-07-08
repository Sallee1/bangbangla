package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.OrderDTO;
import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.pojo.VO.UserCreditVO;
import com.sallee.bangbangla.service.ItemServer;
import com.sallee.bangbangla.service.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
	@Autowired
	public OrderServer orderServer;

	@RequestMapping("/order/addWant")
	public ServerResult addWant(OrderDTO orderDTO) {
		boolean isSuccess = orderServer.addWant(orderDTO);
		return new ServerResult(0,"添加成功",isSuccess);
	}

	@RequestMapping("/order/allBuyer")
	public ServerResult selectAllBuyer(Integer itemId) {
		List<UserCreditVO> list = orderServer.selectAllBuyer(itemId);
		return new ServerResult(0,"查找成功",list);
	}

	@RequestMapping("/order/buyer")
	public ServerResult chooseBuyer(OrderDTO orderDTO) {
		Integer buyerId = orderServer.chooseBuyer(orderDTO);
		return new ServerResult(0,"选择成功",buyerId);
	}

	@RequestMapping("/order/pay")
	public ServerResult pay(Integer itemId) {
		boolean isSuccess = orderServer.pay(itemId);
		return new ServerResult(0,"支付成功",isSuccess);
	}

	@RequestMapping("/order/finish")
	public ServerResult finishOrder(Integer orderId) {
		boolean isSuccess = orderServer.finishOrder(orderId);
		return new ServerResult(0,"订单操作成功",isSuccess);
	}
	@RequestMapping("/order/move")
	public ServerResult moveToHistory(Integer orderId) {
		boolean isSuccess = orderServer.moveToHistory(orderId);
		return new ServerResult(0,"订单操作成功",isSuccess);
	}
}
