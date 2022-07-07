package com.sallee.bangbangla.pojo.VO;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sallee.bangbangla.mapper.OrderMapper;
import com.sallee.bangbangla.pojo.DAO.ItemDAO;
import com.sallee.bangbangla.pojo.DAO.OrderDAO;
import com.sallee.bangbangla.pojo.DAO.OrderHistoryDAO;
import com.sallee.bangbangla.pojo.Enum;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

public class AdminOrderVO {
	Integer id;
	Integer sellerId;
	Integer buyerId;
	Date createTime;
	Date dealTime;
	Date finishTime;
	String state;
	String title;
	String introduce;
	Integer price;
	List<String> imagePaths;
	String mainLabel;
	List<String> subLabel;
	String commit;
	Integer credit;

	public AdminOrderVO() {}

	public AdminOrderVO(ItemDAO itemDAO, OrderMapper orderMapper)
	{
		//克隆参数
		BeanUtils.copyProperties(itemDAO,this);
		//填充买家Id
		Integer id = itemDAO.getId();
		QueryWrapper orderQueryWrapper = new QueryWrapper();
		orderQueryWrapper.eq("item_id",id);
		OrderDAO order = orderMapper.selectOne(orderQueryWrapper);
		if(order != null) {
			this.dealTime = order.getDealTime();
			this.buyerId = order.getBuyerId();
		}
		//装载其他变量
		this.state = Enum.OrderState.values()[itemDAO.getState()].toString();
		this.mainLabel = Enum.MainLabel.values()[itemDAO.getMainLabel()].toString();
	}
	public AdminOrderVO(OrderHistoryDAO orderHistoryDAO)
	{
		BeanUtils.copyProperties(orderHistoryDAO,this);
		//装载其他变量
		this.state = Enum.OrderState.values()[orderHistoryDAO.getState()].toString();
		this.mainLabel = Enum.MainLabel.values()[orderHistoryDAO.getMainLabel()].toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<String> getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(List<String> imagePaths) {
		this.imagePaths = imagePaths;
	}

	public String getMainLabel() {
		return mainLabel;
	}

	public void setMainLabel(String mainLabel) {
		this.mainLabel = mainLabel;
	}

	public List<String> getSubLabel() {
		return subLabel;
	}

	public void setSubLabel(List<String> subLabel) {
		this.subLabel = subLabel;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}
}
