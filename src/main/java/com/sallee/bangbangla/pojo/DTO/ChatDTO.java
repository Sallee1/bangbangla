package com.sallee.bangbangla.pojo.DTO;


public class ChatDTO {
	Integer senderId;
	Integer receiverId;
	String data;
	String type;

	public  ChatDTO(){}

	public ChatDTO(Integer senderId, Integer receiverId, String data, String type) {
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.data = data;
		this.type = type;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
