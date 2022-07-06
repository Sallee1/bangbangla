package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.CreateItemDTO;
import com.sallee.bangbangla.pojo.DTO.ItemEditDTO;
import com.sallee.bangbangla.pojo.DTO.UserBriefInfoDTO;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.service.ItemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ItemController {
	@Autowired
	public ItemServer itemServer;

	@RequestMapping("/item/selectAll")
	public ServerResult selectAllItems(UserBriefInfoDTO userBriefInfoDTO) {

		return null;
	}

	@RequestMapping("/item/key")
	public ServerResult selectItemsWithKey(String key) {

		return null;
	}

	@RequestMapping("/item/Detail")
	public ServerResult showItemDetail(Integer itemId) {

		return null;
	}

	@RequestMapping("/item/add")
	public ServerResult addItem(CreateItemDTO createItemDTO) {

		return null;
	}

	@RequestMapping("/item/edit")
	public ServerResult editItem(ItemEditDTO itemEditDTO) {

		return null;
	}

	@RequestMapping("/item/viewAdd")
	public ServerResult addView(Integer itemId) {

		return null;
	}
}
