package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("chat_list")
public class ChatDAO {
	@TableId(type = IdType.AUTO)
	Integer id;
	Integer senderId;
	Integer receiverId;
	Date sendTime;
	String data;
	Integer type;

	public ChatDAO(){}

	public ChatDAO(Integer id, Integer senderId, Integer receiverId, Date sendTime, String data, Integer type) {
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

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
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
