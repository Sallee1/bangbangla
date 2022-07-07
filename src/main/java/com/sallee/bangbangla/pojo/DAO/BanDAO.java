package com.sallee.bangbangla.pojo.DAO;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("ban_list")
public class BanDAO {
	Integer id;
	Integer banId;
	Integer banType;
	String result;
	Integer opId;
	Date startTime;
	Date endTime;

	public BanDAO() {}

	public BanDAO(Integer id, Integer banId, Integer banType, String result, Integer opId, Date startTime, Date endTime) {
		this.id = id;
		this.banId = banId;
		this.banType = banType;
		this.result = result;
		this.opId = opId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBanId() {
		return banId;
	}

	public void setBanId(Integer banId) {
		this.banId = banId;
	}

	public Integer getBanType() {
		return banType;
	}

	public void setBanType(Integer banType) {
		this.banType = banType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getOpId() {
		return opId;
	}

	public void setOpId(Integer opId) {
		this.opId = opId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
