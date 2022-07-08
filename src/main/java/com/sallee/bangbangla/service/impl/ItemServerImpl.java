package com.sallee.bangbangla.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectCount;
import com.sallee.bangbangla.mapper.ItemMapper;
import com.sallee.bangbangla.mapper.UserMapper;
import com.sallee.bangbangla.pojo.DAO.ItemDAO;
import com.sallee.bangbangla.pojo.DAO.UserDAO;
import com.sallee.bangbangla.pojo.DTO.ItemEditDTO;
import com.sallee.bangbangla.pojo.DTO.UserBriefInfoDTO;
import com.sallee.bangbangla.pojo.Enum;
import com.sallee.bangbangla.pojo.VO.AdminUserVO;
import com.sallee.bangbangla.pojo.VO.ItemDetailVO;
import com.sallee.bangbangla.pojo.VO.ItemVO;
import com.sallee.bangbangla.pojo.DTO.CreateItemDTO;
import com.sallee.bangbangla.service.AdminServer;
import com.sallee.bangbangla.service.ItemServer;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.text.rtf.RTFEditorKit;
import java.util.*;

@Service
public class ItemServerImpl implements ItemServer {
	@Autowired
	public ItemMapper itemMapper;
	@Autowired
	public UserMapper userMapper;

	@Autowired
	public AdminServer adminServer;

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
		List<ItemDAO> itemDAOS = itemMapper.selectList(null);

		//输出匹配结果
		List<ItemVO> itemVOS = new ArrayList<>();
		for (ItemDAO item : itemDAOS) {
			ItemVO temp = new ItemVO();
			//设置参数
			temp.setItemId(item.getId());
			AdminUserVO adminUserVO = adminServer.selectUserWithId(item.getSellerId());
			temp.setSellerNickName(adminUserVO.getNickName());
			temp.setSellerCredit(adminUserVO.getTotalCredit().floatValue() / adminUserVO.getCreditCount());
			temp.setTitle(item.getTitle());
			temp.setPrice(item.getPrice());
			temp.setCreateTime(StaticTool.date2String(item.getCreateTime()));
			temp.setImagePath(item.getImagePaths());
			temp.setMainLabel(Enum.MainLabel.values()[item.getMainLabel()].toString());
			temp.setSubLabel(item.getSubLabel());
			temp.setWant_count(item.getWantCount());
			temp.setView_count(item.getViewCount());
			itemVOS.add(temp);
		}
		return itemVOS;
	}

	@Override
	public List<ItemVO> selectItemsWithKey(UserBriefInfoDTO userBriefInfoDTO, String key) {
		//筛选key
		QueryWrapper keyQueryWrapper = new QueryWrapper();
		keyQueryWrapper.like("title",key);
		keyQueryWrapper.or();
		keyQueryWrapper.like("sub_label",key);

		List<ItemDAO> itemDAOS = itemMapper.selectList(keyQueryWrapper);
		//输出匹配结果
		List<ItemVO> itemVOS = new ArrayList<>();
		for(ItemDAO item:itemDAOS) {
			ItemVO temp = new ItemVO();
			//设置参数
			temp.setItemId(item.getId());
			AdminUserVO adminUserVO = adminServer.selectUserWithId(item.getSellerId());
			temp.setSellerNickName(adminUserVO.getNickName());
			temp.setSellerCredit(adminUserVO.getTotalCredit().floatValue()/adminUserVO.getCreditCount());
			temp.setTitle(item.getTitle());
			temp.setPrice(item.getPrice());
			temp.setCreateTime(StaticTool.date2String(item.getCreateTime()));
			temp.setImagePath(item.getImagePaths());
			temp.setMainLabel(Enum.MainLabel.values()[item.getMainLabel()].toString());
			temp.setSubLabel(item.getSubLabel());
			temp.setWant_count(item.getWantCount());
			temp.setView_count(item.getViewCount());
			itemVOS.add(temp);
		}
		return itemVOS;
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
		itemDetailVO.setCreateTime(StaticTool.date2String(itemDAO.getCreateTime()));
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
		itemDAO.setPrice(itemEditDTO.getScore());

		int Row = itemMapper.update(itemDAO,queryWrapper);

		return Row>=1?true:false;
	}

	@Override
	public boolean addView(Integer itemId) {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("id",itemId);

		ItemDAO itemDAO = itemMapper.selectOne(queryWrapper);
		itemDAO.setViewCount(itemDAO.getViewCount()+1);
		itemMapper.update(itemDAO,queryWrapper);
		return true;
	}
}
