package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("char_list")
public class ChatDAO {
	Integer id;
	Integer senderId;
	Integer receiverId;
	Long sendTime;
	String data;
	Integer type;

	public ChatDAO(){}

	public ChatDAO(Integer id, Integer senderId, Integer receiverId, Long sendTime, String data, Integer type) {
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.sendTime = sendTime;
		this.data = data;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	public Long getSendTime() {
		return sendTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
