package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user_item_relate_history")
public class OrderHistoryDAO {
	Integer id;
	Integer itemId;
	Integer buyerId;

	public OrderHistoryDAO(){}

	public OrderHistoryDAO(Integer id, Integer itemId, Integer buyerId) {
		this.id = id;
		this.itemId = itemId;
		this.buyerId = buyerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
}
