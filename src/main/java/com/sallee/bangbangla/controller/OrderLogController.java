package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.UserItemRelateDTO;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.service.OrderLogServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderLogController {
	@Autowired
	public OrderLogServer orderLogServer;

	@RequestMapping("/orderLog/form")
	public ServerResult showOrderFrom(Integer userId) {

		return null;
	}

	@RequestMapping("/orderLog/to")
	public ServerResult showOrderTo(Integer userId) {

		return null;
	}

	@RequestMapping("/orderLog/detail")
	public ServerResult showOrderDetail(UserItemRelateDTO userItemRelateDTO) {

		return null;
	}
}
