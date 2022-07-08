package com.sallee.bangbangla.controller;


import com.sallee.bangbangla.pojo.DTO.CreateItemDTO;
import com.sallee.bangbangla.pojo.DTO.ItemEditDTO;
import com.sallee.bangbangla.pojo.DTO.UserBriefInfoDTO;
import com.sallee.bangbangla.pojo.ServerResult;
import com.sallee.bangbangla.pojo.VO.ItemDetailVO;
import com.sallee.bangbangla.pojo.VO.ItemVO;
import com.sallee.bangbangla.service.ItemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ItemController {
	@Autowired
	public ItemServer itemServer;

	@RequestMapping("/item/selectAll")
	public ServerResult selectAllItems(UserBriefInfoDTO userBriefInfoDTO) {
		List<ItemVO> voList = itemServer.selectAllItems(userBriefInfoDTO);

		return new ServerResult(0,"查询成功",voList);
	}

	@RequestMapping("/item/key")
	public ServerResult selectItemsWithKey(UserBriefInfoDTO userBriefInfoDTO,String key) {
		List<ItemVO> voList = itemServer.selectItemsWithKey(userBriefInfoDTO,key);

		return new ServerResult(0,"查询成功",voList);
	}

	@RequestMapping("/item/Detail")
	public ServerResult showItemDetail(Integer itemId) {
		ItemDetailVO itemDetailVO = itemServer.showItemDetail(itemId);

		return new ServerResult(0,"查询成功",itemDetailVO);
	}

	@RequestMapping("/item/add")
	public ServerResult addItem(CreateItemDTO createItemDTO) {
		boolean isSuc = itemServer.addItem(createItemDTO);

		if(isSuc)
			return new ServerResult(0,"增加成功",null);
		else
			return new ServerResult(1,"添加失败",null);
	}

	@RequestMapping("/item/edit")
	public ServerResult editItem(ItemEditDTO itemEditDTO) {
		boolean isSuc = itemServer.editItem(itemEditDTO);

		if(isSuc)
			return new ServerResult(0,"修改成功",null);
		else
			return new ServerResult(1,"修改失败",null);
	}

	@RequestMapping("/item/viewAdd")
	public ServerResult addView(Integer itemId) {
		boolean isSuc = itemServer.addView(itemId);

		if(isSuc)
			return new ServerResult(0,"增加成功",null);
		else
			return new ServerResult(1,"添加失败",null);

	}
}
