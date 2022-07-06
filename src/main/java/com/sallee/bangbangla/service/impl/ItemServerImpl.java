package com.sallee.bangbangla.service.impl;


import com.sallee.bangbangla.mapper.ItemMapper;
import com.sallee.bangbangla.mapper.UserMapper;
import com.sallee.bangbangla.pojo.DTO.ItemEditDTO;
import com.sallee.bangbangla.pojo.DTO.UserBriefInfoDTO;
import com.sallee.bangbangla.pojo.VO.ItemDetailVO;
import com.sallee.bangbangla.pojo.VO.ItemVO;
import com.sallee.bangbangla.pojo.DTO.CreateItemDTO;
import com.sallee.bangbangla.service.ItemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServerImpl implements ItemServer {
	@Autowired
	public ItemMapper itemMapper;
	@Autowired
	public UserMapper userMapper;

	@Override
	public List<ItemVO> selectAllItems(UserBriefInfoDTO userBriefInfoDTO) {
		return null;
	}

	@Override
	public List<ItemVO> selectItemsWithKey(UserBriefInfoDTO userBriefInfoDTO, String key) {
		return null;
	}

	@Override
	public ItemDetailVO showItemDetail(Integer itemId) {
		return null;
	}

	@Override
	public boolean addItem(CreateItemDTO createItemDTO) {
		return false;
	}

	@Override
	public boolean editItem(ItemEditDTO itemEditDTO) {
		return false;
	}

	@Override
	public boolean addView(Integer itemId) {
		return false;
	}
}
