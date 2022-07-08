package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sallee.bangbangla.mapper.ItemMapper;
import com.sallee.bangbangla.mapper.UserMapper;
import com.sallee.bangbangla.pojo.DAO.ItemDAO;
import com.sallee.bangbangla.pojo.DAO.UserDAO;
import com.sallee.bangbangla.pojo.DTO.ItemEditDTO;
import com.sallee.bangbangla.pojo.DTO.UserBriefInfoDTO;
import com.sallee.bangbangla.pojo.Enum;
import com.sallee.bangbangla.pojo.VO.ItemDetailVO;
import com.sallee.bangbangla.pojo.VO.ItemVO;
import com.sallee.bangbangla.pojo.DTO.CreateItemDTO;
import com.sallee.bangbangla.service.ItemServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemServerImpl implements ItemServer {
	@Autowired
	public ItemMapper itemMapper;
	@Autowired
	public UserMapper userMapper;

//	Integer itemId;
//	String sellerNickName;
//	Float sellerCredit;
//	Date createTime;
//	String title;
//	Integer price;
//	String imagePath;
//	String mainLabel;
//	List<String> subLabel;
//	Integer want_count;
//	Integer view_count;


	@Override
	public List<ItemVO> selectAllItems(UserBriefInfoDTO userBriefInfoDTO) {
		QueryWrapper userQueryWrapper = new QueryWrapper();
		userQueryWrapper.eq("university_name",userBriefInfoDTO.getUniversityName());

		List<UserDAO> userscholList = userMapper.selectList(userQueryWrapper);

		ArrayList<ItemVO> itemVoList = new ArrayList<>();
		for(UserDAO userDAO:userscholList){
			QueryWrapper queryWrapper = new QueryWrapper();
			queryWrapper.eq("seller_id",userDAO.getId());

			ItemDAO itemDAO = itemMapper.selectOne(queryWrapper);
			ItemVO itemVO = new ItemVO();

			if(itemDAO == null){
				break;
			}

			Float a = new Float(userDAO.getTotalCredit()/userDAO.getCreditCount());

			itemVO.setItemId(itemDAO.getId());
			itemVO.setSellerNickName(userDAO.getNickName());
			itemVO.setSellerCredit(a);
			itemVO.setCreateTime(itemDAO.getCreateTime());
			itemVO.setTitle(itemDAO.getTitle());
			itemVO.setPrice(itemDAO.getPrice());
			itemVO.setImagePath(itemDAO.getImagePaths());
			itemVO.setMainLabel(Enum.MainLabel.values()[itemDAO.getMainLabel()].toString());
			itemVO.setSubLabel(itemDAO.getSubLabel());
			itemVO.setWant_count(itemDAO.getWantCount());
			itemVO.setView_count(itemDAO.getViewCount());

			itemVoList.add(itemVO);
		}

		return itemVoList;
	}

	@Override
	public List<ItemVO> selectItemsWithKey(UserBriefInfoDTO userBriefInfoDTO, String key) {
		QueryWrapper userQueryWrapper = new QueryWrapper();
		userQueryWrapper.eq("university_name",userBriefInfoDTO.getUniversityName());

		List<UserDAO> userscholList = userMapper.selectList(userQueryWrapper);

		ArrayList<ItemVO> itemVoList = new ArrayList<>();
		for(UserDAO userDAO:userscholList){
			QueryWrapper queryWrapper = new QueryWrapper();
			queryWrapper.eq("seller_id",userDAO.getId());

			ItemDAO itemDAO = itemMapper.selectOne(queryWrapper);
			ItemVO itemVO = new ItemVO();

			if(itemDAO == null){
				break;
			}

			Integer count=0 ;
			for(String key0:itemDAO.getSubLabel()){
				if(key.matches(key0))
					count = count + 1;
			}
			if(count == 0 &&!key.matches(itemDAO.getTitle()))
				break;

			Float a = new Float(userDAO.getTotalCredit()/userDAO.getCreditCount());

			itemVO.setItemId(itemDAO.getId());
			itemVO.setSellerNickName(userDAO.getNickName());
			itemVO.setSellerCredit(a);
			itemVO.setCreateTime(itemDAO.getCreateTime());
			itemVO.setTitle(itemDAO.getTitle());
			itemVO.setPrice(itemDAO.getPrice());
			itemVO.setImagePath(itemDAO.getImagePaths());
			itemVO.setMainLabel(Enum.MainLabel.values()[itemDAO.getMainLabel()].toString());
			itemVO.setSubLabel(itemDAO.getSubLabel());
			itemVO.setWant_count(itemDAO.getWantCount());
			itemVO.setView_count(itemDAO.getViewCount());

			itemVoList.add(itemVO);
		}

		return itemVoList;
	}

	@Override
	public ItemDetailVO showItemDetail(Integer itemId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",itemId);

		ItemDAO itemDAO = itemMapper.selectOne(queryWrapper);

		QueryWrapper userqueryWrapper = new QueryWrapper();
		userqueryWrapper.eq("id",itemDAO.getSellerId());

		UserDAO userDAO = userMapper.selectOne(queryWrapper);

		ItemDetailVO itemDetailVO = new ItemDetailVO();

		Float a = new Float(userDAO.getTotalCredit()/userDAO.getCreditCount());

		itemDetailVO.setItemId(itemDAO.getId());
		itemDetailVO.setSellerNickName(userDAO.getNickName());
		itemDetailVO.setSellerCredit(a);
		itemDetailVO.setCreateTime(itemDAO.getCreateTime());
		itemDetailVO.setTitle(itemDAO.getTitle());
		itemDetailVO.setPrice(itemDAO.getPrice());
		itemDetailVO.setIntroduce(itemDAO.getIntroduce());
		itemDetailVO.setImagePaths(itemDAO.getImagePaths());
		itemDetailVO.setMainLable(Enum.MainLabel.values()[itemDAO.getMainLabel()].toString());
		itemDetailVO.setSubLabel(itemDAO.getSubLabel());
		itemDetailVO.setWant_count(itemDAO.getWantCount());
		itemDetailVO.setView_count(itemDAO.getViewCount());

		return itemDetailVO;
	}

	@Override
	public boolean addItem(CreateItemDTO createItemDTO) {
		ItemDAO itemDAO = new ItemDAO();

		itemDAO.setSellerId(createItemDTO.getSellerId());
		itemDAO.setTitle(createItemDTO.getTitle());
		itemDAO.setIntroduce(createItemDTO.getIntroduce());
		itemDAO.setPrice(createItemDTO.getPrice());
		itemDAO.setImagePaths(createItemDTO.getImageData());
		itemDAO.setMainLabel(Enum.MainLabel.valueOf(createItemDTO.getMainLabel()).ordinal());
		itemDAO.setSubLabel(createItemDTO.getSubLabel());
		BeanUtils.copyProperties(createItemDTO,itemDAO);
		int Row = itemMapper.insert(itemDAO);
		return Row>=1?true:false;
	}

	@Override
	public boolean editItem(ItemEditDTO itemEditDTO) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",itemEditDTO.getItemId());

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.setCredit(itemEditDTO.getScore());

		int Row = itemMapper.update(itemDAO,queryWrapper);


		return Row>=1?true:false;
	}

	@Override
	public boolean addView(Integer itemId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",itemId);

		ItemDAO itemDAO = itemMapper.selectOne(queryWrapper);
		itemDAO.setViewCount(itemDAO.getViewCount()+1);
		return true;
	}
}
