package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.service.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderController {
	@Autowired
	public OrderServer orderServer;

	@RequestMapping("/order/addWant")
	public ServerResult addWant(UserItemRelateDTO userItemRelateDTO) {

		return null;
	}

	@RequestMapping("/order/allBuyer")
	public ServerResult selectAllBuyer(Integer itemId) {

		return null;
	}

	@RequestMapping("/order/buyer")
	public ServerResult chooseBuyer(UserItemRelateDTO userItemRelateDTO) {

		return null;
	}

	@RequestMapping("/order/pay")
	public ServerResult pay(Integer orderId) {

		return null;
	}

	@RequestMapping("/order/finish")
	public ServerResult finishOrder(Integer orderId) {

		return null;
	}

	@RequestMapping("/order/move")
	public ServerResult moveToHistory(Integer orderId) {

		return null;
	}
}
